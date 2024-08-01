// https://www.acmicpc.net/problem/2156

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.valueOf(br.readLine());
        int[] wines = new int[N];
        
        for(int i = 0; i < N; i++){
            wines[i] = Integer.valueOf(br.readLine());
        }

        if(N == 1){
            System.out.println(wines[0]);
        }
        else if(N == 2){
            System.out.println(wines[0] + wines[1]);
        }
        else{
            int[] dp = new int[N+1];
            dp[0] = wines[0];
            dp[1] = wines[0] + wines[1];
            dp[2] = Math.max(wines[0]+wines[1], Math.max(wines[0]+wines[2], wines[1]+wines[2]));
            
            for(int i = 3; i < N; i++){
                dp[i] = Math.max(dp[i-1], Math.max(dp[i-2]+wines[i], dp[i-3]+wines[i-1]+wines[i]));
            }

            System.out.println(dp[N-1]);
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
