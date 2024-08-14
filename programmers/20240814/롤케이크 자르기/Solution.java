// https://school.programmers.co.kr/learn/courses/30/lessons/132265

import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int n = topping.length;
        HashMap<Integer, Integer> first = new HashMap<>();
        HashMap<Integer, Integer> second = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            if(second.containsKey(topping[i])) 
                second.put(topping[i], second.get(topping[i]) + 1);
            else
                second.put(topping[i], 1);
        }
        
        int answer = 0;
        for(int i = 0; i < n; i++){
            first.put(topping[i], 1);
            
            if(second.get(topping[i]) == 1)
                second.remove(topping[i]);
            else 
                second.put(topping[i], second.get(topping[i]) - 1);
            
            if(first.size() == second.size())
                answer++;
            else if(first.size() > second.size())
                break;
        }
        return answer;
    }
}
