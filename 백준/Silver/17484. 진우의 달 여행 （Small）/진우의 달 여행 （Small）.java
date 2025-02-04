import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        int[][][] dp = new int[n][m][3];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                Arrays.fill(dp[i][j], (int)1e9);
            }
        }

        for(int j = 0; j < m; j++) {
            dp[0][j][0] = map[0][j];
            dp[0][j][1] = map[0][j];
            dp[0][j][2] = map[0][j];
        }

        for(int i = 1; i < n; i++) {
            dp[i][0][1] = map[i][0] + dp[i-1][0][2];
            dp[i][0][2] = map[i][0] + Math.min(dp[i-1][1][0], dp[i-1][1][1]);
            
            for(int j = 1; j < m - 1; j++) {
                dp[i][j][0] = map[i][j] + Math.min(dp[i-1][j-1][1], dp[i-1][j-1][2]);
                dp[i][j][1] = map[i][j] + Math.min(dp[i-1][j][0], dp[i-1][j][2]);
                dp[i][j][2] = map[i][j] + Math.min(dp[i-1][j+1][0], dp[i-1][j+1][1]);
            }
            
            dp[i][m-1][0] = map[i][m-1] + Math.min(dp[i-1][m-2][1], dp[i-1][m-2][2]);
            dp[i][m-1][1] = map[i][m-1] + dp[i-1][m-1][0];
        }

        int min = 1000000000;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < 3; j++) {
                min = Math.min(min, dp[n-1][i][j]);
            }
        }

        System.out.print(min);
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}