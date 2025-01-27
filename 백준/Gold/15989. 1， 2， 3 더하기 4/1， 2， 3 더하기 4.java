import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        int[] dp = new int[10001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for(int i = 4; i <= 10000; i++) {
            dp[i] = 1 + i/2 + dp[i-3];
        }

        StringBuilder sb = new StringBuilder();
        for(int test = 0; test < t; test++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append("\n");
        }
        System.out.print(sb);
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}