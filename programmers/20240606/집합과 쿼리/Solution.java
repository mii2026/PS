// https://school.programmers.co.kr/learn/courses/30/lessons/214291

import java.util.*;

class Solution {
    private int ngroup;
    private int[] group;
    private int[] prev;
    private int[] next;
    private int[] same;
    private Map<Integer, Integer> map = new HashMap<>();

    public String[] solution(int n, int[][] queries) {
        ngroup = n;
        group = new int[n];
        prev = new int[n];
        next = new int[n];
        same = new int[n];
        for (int i = 0; i < n; i++) {
            group[i] = i;
            prev[i] = i;
            next[i] = i;
            same[i] = -1;
            map.put(i, i);
        }
        
        List<String> checks = new ArrayList<>();
        for (int[] query : queries) {
            if(query[0] == 1){
                    union(query[1], query[2]);
            }
            else if(query[0] == 2){
                splitNewGroup(query[1], query[2]);
            }
            else if(query[0] == 3){
                if (find(query[1]) == find(query[2])) {
                    checks.add("Yes");
                } else {
                    checks.add("No");
                }
            }
        }
        
        String[] answer = checks.toArray(String[]::new);
        return answer;
    }
    
    private int findTop(int x){
        int i = x;
        while (same[i] != -1) {
            i = same[i];
        }
        
        while (same[x] != -1) {
            int n = same[x];
            same[x] = i;
            x = n;
        }
        
        return i;
    }

    private int find(int x) {
        return group[findTop(x)];
    }
    
    private int unionNext(int t){
        int n = next[t];
        
        next[t] = next[n];
        prev[next[n]] = t;
        
        prev[n] = -1;
        next[n] = -1;
        same[n] = t;
        return n;
    }

    private void union(int n1, int n2) {
        int g1 = find(n1);
        int g2 = find(n2);
        
        if (g1 != g2) {
            int p2 = map.get(g2);
            map.remove(g2);
            while (next[p2] != p2) {
                unionNext(p2);
            }

            int p1 = map.get(g1);
            int p = prev[p1];
            prev[p2] = p;
            next[p2] = p1;
            prev[p1] = p2;
            next[p] = p2; 
            group[p2] = g1;
        }
    }

    private boolean checkNext(int p, int st, int et) {
        int i = next[st];
        while (i != p && i != et) {
            i = next[i];
        }
        return i != p;
    }

    private void splitNewGroup(int start, int end) {
        int st = findTop(start);
        int et = findTop(end);
        int g = group[st];
        
        if (st != et) {
            if (!checkNext(map.get(g), st, et)) {
                return;
            }
            while (unionNext(st) != et);
        }
        
        if (map.get(g) == st) {
            if (next[st] == st) {
                return;
            } else {
                map.put(g, next[st]);
            }
        }
        
        int n = next[st];
        int p = prev[st];
        next[p] = n;
        prev[n] = p;
       
        prev[st] = st;
        next[st] = st;
        group[st] = ngroup;
        map.put(ngroup, st);
        ngroup++;
    }
}