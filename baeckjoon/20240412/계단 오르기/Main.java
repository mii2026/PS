// https://www.acmicpc.net/problem/2579

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());
        int[] steps = new int[N];
        
        for(int i = 0; i < N; i++){
            steps[i] = Integer.valueOf(br.readLine());
        }

        if(N == 1){
            System.out.println(steps[0]);
        }
        else if(N == 2){
            System.out.println(steps[1]+steps[0]);
        }
        else{
            int dp[] = new int[N];
            dp[0] = steps[0];
            dp[1] = steps[0] + steps[1];
            dp[2] = steps[2] + Math.max(steps[0], steps[1]);

            for(int i = 3; i < N; i++){
                dp[i] = steps[i] + Math.max(dp[i-3]+steps[i-1], dp[i-2]);
            }

            System.out.println(dp[N-1]);
        }
    }

    public static void main(String[] args) throws Exception {
       new Main().solution();
    }
}
