// https://www.acmicpc.net/problem/7579

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][2];
        int[] dp = new int[10001];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i][0] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n; i++){
            for(int j = 10000; j >= arr[i][1]; j--){
                dp[j] = Math.max(dp[j], dp[j-arr[i][1]] + arr[i][0]);
            }
        }

        for(int i = 0; i < 10001; i++){
            if(dp[i] >= m){
                System.out.print(i);
                break;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}