// https://www.acmicpc.net/problem/10942

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        boolean[][] dp = new boolean[n][n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n; i++){
            dp[i][i] = true;
        }

        for(int i = 0; i < n - 1; i++){
            if(arr[i] == arr[i+1]){
                dp[i][i+1] = true;
            }
        }

        for(int i = 2; i < n; i++){
            for(int j = 0; i + j < n; j++){
                if(dp[j+1][i+j-1] && arr[j] == arr[i+j]){
                    dp[j][i+j] = true;
                }
            }
        }

        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());

            int n1 = Integer.parseInt(st.nextToken()) - 1;
            int n2 = Integer.parseInt(st.nextToken()) - 1;

            sb.append(dp[n1][n2] ? 1 : 0).append("\n");
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
​