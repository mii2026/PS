// https://school.programmers.co.kr/learn/courses/30/lessons/42578

import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < clothes.length; i++){
            String str = clothes[i][1];
            if(hashMap.containsKey(str)){
                hashMap.put(str, hashMap.get(str) + 1);
            }
            else{
                hashMap.put(str, 1);
            }
        }
        
        int answer = 1;
        for(String str: hashMap.keySet()){
            answer *= (hashMap.get(str)+1);
        }
        return answer-1;
    }
}