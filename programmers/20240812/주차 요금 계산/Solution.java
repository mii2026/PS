// https://school.programmers.co.kr/learn/courses/30/lessons/92341

import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> prev = new HashMap<>();
        
        for(int i = 0; i < records.length; i++){
            int time = getTime(records[i].split(" ")[0]);
            String num = records[i].split(" ")[1];
            String state = records[i].split(" ")[2];
            
            if(state.equals("IN")) {
                prev.put(num, time);
            } else {
                int prevTime = prev.remove(num);
                int interval = time - prevTime;
                
                if(map.containsKey(num)) {
                    map.put(num, map.get(num) + interval);
                } else {
                    map.put(num, interval);
                }
            }
        }
        
        for(String num: prev.keySet()){
            int prevTime = prev.get(num);
            int interval = 1439 - prevTime;

            if(map.containsKey(num)) {
                map.put(num, map.get(num) + interval);
            } else {
                map.put(num, interval);
            }
        }
        
        String[] keys = map.keySet().toArray(new String[0]);
        Arrays.sort(keys);
        
        int[] answer = new int[keys.length];
        for(int i = 0; i < keys.length; i++){
            int interval = map.get(keys[i]);
            int cost = fees[1];
            if(interval > fees[0]){
                cost += ((interval - fees[0] + fees[2] - 1) / fees[2]) * fees[3];
            }
            answer[i] = cost;
        }
        return answer;
    }
    
    public int getTime(String time){
        String[] times = time.split(":");
        return Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]); 
    }
}
