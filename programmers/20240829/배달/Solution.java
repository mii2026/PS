// https://school.programmers.co.kr/learn/courses/30/lessons/12978

import java.util.*;

class Solution {
    final int inf = 1000000000;
    
    public class Road{
        int n, weight;
        
        public Road(int n, int weight){
            this.n = n;
            this.weight = weight;
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        int[] dist = new int[N+1];
        for(int i = 2; i <= N; i++)
            dist[i] = inf;
        
        ArrayList<Road>[] map = new ArrayList[N+1];
        for(int i = 1; i <= N; i++)
            map[i] = new ArrayList<>();
        
        for(int i = 0; i < road.length; i++){
            int n1 = road[i][0];
            int n2 = road[i][1];
            int weight = road[i][2];
            
            map[n1].add(new Road(n2, weight));
            map[n2].add(new Road(n1, weight));
        }
        
        PriorityQueue<Road> q = new PriorityQueue<>((i, j) -> i.weight - j.weight);
        boolean[] visited = new boolean[N+1];
        q.add(new Road(1, 0));
        
        while(!q.isEmpty()){
            Road cur = q.poll();
            
            if(visited[cur.n]) continue;
            visited[cur.n] = true;
            
            for(Road next: map[cur.n]){
                int nweight = cur.weight + next.weight;
                
                if(nweight < dist[next.n]){
                    dist[next.n] = nweight;
                    q.add(new Road(next.n, nweight));
                }
            }
        }
                
        int answer = 0;
        for(int i = 1; i <= N; i++){
            if(dist[i] <= K) answer++;
        }
        return answer;
    }
}
