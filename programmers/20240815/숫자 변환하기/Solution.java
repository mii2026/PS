// https://school.programmers.co.kr/learn/courses/30/lessons/154538

class Solution {
    public int solution(int x, int y, int n) {
        int[] dp = new int[y + 1];
        for(int i = 0; i <= y; i++){
            dp[i] = 1000000000;
        }
        
        dp[x] = 0;
        for(int i = x; i < y; i++){
            if(2 * i <= y)
                dp[2 * i] = Math.min(dp[2 * i], dp[i] + 1);
            if(3 * i <= y)
                dp[3 * i] = Math.min(dp[3 * i], dp[i] + 1);
            if(i + n <= y)
                dp[i + n] = Math.min(dp[i + n], dp[i] + 1);
        }
        
        if(dp[y] >= 1000000000)
            return -1;
        return dp[y];
    }
}
