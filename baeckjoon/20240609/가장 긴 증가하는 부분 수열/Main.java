// https://www.acmicpc.net/problem/14002

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int idx = 0;
        int[] dp = new int[n];
        int[] prev = new int[n];

        for(int i = 0; i < n; i++){
            dp[i] = 1;
            prev[i] = -1;
        }

        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(arr[j] < arr[i] && dp[i] < dp[j] + 1){
                    dp[i] = dp[j]+1;
                    prev[i] = j;
                }
            }
            if(dp[i] > dp[idx])
                idx = i;
        }

        System.out.println(dp[idx]);

        StringBuilder sb = new StringBuilder();
        while(idx != -1){
            sb.insert(0, arr[idx]+" ");
            idx = prev[idx];
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
