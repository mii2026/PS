// https://www.acmicpc.net/problem/11066 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for(int test = 0; test < t; test++){
            int answer = 0;
            int n = Integer.parseInt(br.readLine());
            int[][] dp = new int[n][n];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                dp[i][i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 0; i < n; i++){
                for(int j = i + 1; j < n; j++){
                    dp[i][j] = dp[i][j-1] + dp[j][j];
                }
                dp[i][i] = 0;
            }

            for(int i = 2; i < n; i++){
                for(int j = 0; i + j < n; j++){
                    int min = Integer.MAX_VALUE;
                    for(int k = j; k < i+j; k++){
                        min = Math.min(min, dp[j][i+j] + dp[j][k] + dp[k+1][i+j]);
                    }
                    dp[j][i+j] = min;
                }
            }

            sb.append(dp[0][n-1]).append("\n");
        }

        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
​