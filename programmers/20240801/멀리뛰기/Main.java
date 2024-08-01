// https://school.programmers.co.kr/learn/courses/30/lessons/12914

class Solution {
    public long solution(int n) {
        final int mod = 1234567;
        
        int[] dp = new int[n+1];
        dp[0] = 1;
        
        for(int i = 0; i < n - 1; i++){
            dp[i+1] = (dp[i+1] + dp[i]) % mod;
            dp[i+2] = (dp[i+2] + dp[i]) % mod;
        }
        
        dp[n] = (dp[n] + dp[n-1]) % mod;
        
        return dp[n];
    }
}
