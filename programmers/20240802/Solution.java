// https://school.programmers.co.kr/learn/courses/30/lessons/138476

import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < tangerine.length; i++){
            if(map.containsKey(tangerine[i])){
                map.put(tangerine[i], map.get(tangerine[i])+1);
            } else {
                map.put(tangerine[i], 1);
            }
        }
        
        List<Integer> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1, o2) -> map.get(o2)-map.get(o1));
        
        int answer = 0;
        int w = 0;
        for(int i: keySet){
            answer++;
            w += map.get(i);
            
            if(w >= k)
                break;
        }
        return answer;
    }
}
