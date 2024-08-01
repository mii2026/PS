// https://school.programmers.co.kr/learn/courses/30/lessons/42747

import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        
        int max = -1;
        int num = 0;
        for(int i = citations.length-1; i>=0; i--){
            if(citations[i] <= ++num){
                max = Math.max(citations[i], num-1);
                break;
            }
        }
        if(max == -1){
            max = num;
        }
        return max;
    }
}
​