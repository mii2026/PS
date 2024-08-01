// https://www.acmicpc.net/problem/2482

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private final int mod = 1000000003;
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        if(k == 1){
            System.out.print(n);
            return;
        }
        if(n < k*2){
            System.out.print(0);
            return;
        }

        int[][] dp = new int[n+1][k+1];
        for(int i = 0; i <= n; i++){
            dp[i][0] = 1;
            dp[i][1] = i;
        }


        for(int i = 3; i < n; i++){
            for(int j = 2; j <= k; j++){
                dp[i][j] = dp[i-2][j-1] + dp[i-1][j];
                dp[i][j] %= mod;
            }
        }

        dp[n][k] = dp[n-3][k-1] + dp[n-1][k];
        dp[n][k] %= mod;
        System.out.print(dp[n][k]);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
​