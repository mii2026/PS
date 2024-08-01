// https://www.acmicpc.net/problem/17404

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    final int inf = 1000000000;
    
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] cost = new int[n+1][3];

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken());
            cost[i][1] = Integer.parseInt(st.nextToken());
            cost[i][2] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n+1][3];
        int answer = inf;

        for(int start = 0; start < 3; start++){
            for(int i = 0; i < 3; i++){
                if(start == i)
                    dp[1][i] = cost[1][i];
                else   
                    dp[1][i] = inf;
            }

            for(int i = 2; i <= n; i++){
                dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + cost[i][0];
                dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + cost[i][1];
                dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + cost[i][2];
            }

            for(int i = 0; i < 3; i++){
                if(start == i)
                    continue;
                answer = Math.min(answer, dp[n][i]);
            }
        }

        System.out.print(answer);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
​