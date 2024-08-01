// https://www.acmicpc.net/problem/12865

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        int N = Integer.valueOf(input[0]); 
        int K = Integer.valueOf(input[1]);

        int[] dp = new int[K+1];

        for(int i = 0; i < N; i++){
            input = br.readLine().split(" ");
            int W = Integer.valueOf(input[0]);
            int V = Integer.valueOf(input[1]);

            for(int j = K; j >= W; j--){
                dp[j] = Math.max(dp[j], dp[j-W]+V);
            }
        }

        System.out.println(dp[K]);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
