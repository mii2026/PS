// https://school.programmers.co.kr/learn/courses/30/lessons/131127

import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        
        int n = want.length;
        
        HashMap<String, Integer> map = new HashMap<>();
        int[] arr = new int[n];
        int answer = 0;
        int idx1 = 10;
        int idx2 = 0;
        
        for(int i = 0; i < n; i++){
            map.put(want[i], i);
        }
        
        for(int i = 0; i < 10; i++){
            if(map.get(discount[i]) != null)
                arr[map.get(discount[i])]++;
        }
        
        boolean able = true;
        for(int i = 0; i < n; i++){
            if(arr[i] != number[i]){
                able = false;
                break;
            }
        }
        if(able)
            answer++;
                
        while(idx1 < discount.length){
            if(map.containsKey(discount[idx2]))
                arr[map.get(discount[idx2])]--;
            idx2++;
            
            if(map.containsKey(discount[idx1]))
                arr[map.get(discount[idx1])]++;
            idx1++;
            
            able = true;
            for(int i = 0; i < n; i++){
                if(arr[i] != number[i]){
                    able = false;
                    break;
                }
            }
            if(able)
                answer++;
        }
        
        return answer;
    }
}
