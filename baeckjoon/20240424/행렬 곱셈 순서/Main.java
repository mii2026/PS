// https://www.acmicpc.net/problem/11049

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    int[][] arr;
    int[][] dp;
    
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][2];
        dp = new int[n][n];

        StringTokenizer st;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i < n; i++){
            for(int start = 0; start + i < n; start++){
                int end = start + i;
                int min = Integer.MAX_VALUE;
                
                for(int k = start; k < end; k++){
                    min = Math.min(min, getCount(start, k, end));
                }

                dp[start][end] = min;
            }
        }

        System.out.print(dp[0][n-1]);
    }

    public int getCount(int start, int k, int end){
        return dp[start][k] + dp[k+1][end] + (arr[start][0] * arr[k][1] * arr[end][1]);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
