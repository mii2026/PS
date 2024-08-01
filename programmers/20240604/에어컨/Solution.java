// https://school.programmers.co.kr/learn/courses/30/lessons/214289 

class Solution {
    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard){
        int gap = t2 - t1;
        if(temperature > t2){
            t1 = temperature - t2;
            t2 = t1 + gap;
        }
        else if(temperature < t1){
            t1 = t1 - temperature;
            t2 = t1 + gap;
        }
        
        final int inf = 1000000;
        int[][] dp = new int[onboard.length][t2+1];
        for(int i = 1; i < t2 + 1; i++){
            dp[0][i] = inf;
        }
        
        for(int i = 1; i < onboard.length; i++){   
            for(int j = 0; j < t2 + 1; j++){
                if(onboard[i] == 1 && j < t1){
                    dp[i][j] = inf;
                    continue;
                }
                
                if(j == 0){
                    dp[i][j] = dp[i-1][j];
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j+1]);
                }
                else{
                    dp[i][j] = dp[i-1][j] + b;
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1] + a);
                    if(j != t2){
                        dp[i][j] = Math.min(dp[i][j], dp[i-1][j+1]);
                    }
                }
            }
        }
        
        int answer = 1000000;
        for(int i = 0; i < t2+1; i++){
            answer = Math.min(answer, dp[onboard.length-1][i]);
        }
        return answer;
    }
}