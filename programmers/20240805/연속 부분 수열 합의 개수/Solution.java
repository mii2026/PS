// https://school.programmers.co.kr/learn/courses/30/lessons/131701

import java.util.ArrayList;

class Solution {
    public int solution(int[] elements) {
        
        int answer = 0;
        
        int n = elements.length;
        int[][] dp = new int[n][n];
        boolean[] contains = new boolean[1000000];
        
        for(int i = 0; i < n; i++){
            dp[i][i] = elements[i];
            
            if(!contains[elements[i]]){
                contains[elements[i]] = true;
                answer++;
            }
            
            for(int j = 1; j < n; j++){
                int next = (i + j) % n;
                int prev = (next - 1 + n) % n;
                
                dp[i][next] = dp[i][prev] + elements[next];
                
                if(!contains[dp[i][next]]){
                    contains[dp[i][next]] = true;
                    answer++;
                }
            }
        }
        
        return answer;
    }
}
