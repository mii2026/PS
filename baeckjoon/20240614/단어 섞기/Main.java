// https://www.acmicpc.net/problem/9177

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str1 = st.nextToken();
            String str2 = st.nextToken();
            String target = st.nextToken();

            boolean result = canMake(str1, str2, target);

            sb.append("Data set ")
              .append(i)
              .append(": ")
              .append(result ? "yes\n" : "no\n");
        }

        System.out.print(sb);
    }

    public boolean canMake(String str1, String str2, String target){
        int n1 = str1.length();
        int n2 = str2.length();
        boolean[][] dp = new boolean[n1+1][n2+1];

        dp[0][0] = true;
        
        for(int i = 1; i <= n1; i++){
            if(str1.charAt(i-1) == target.charAt(i-1)) dp[i][0] = true;
            else break;
        }
        
        for(int j = 1; j <= n2; j++){
            if(str2.charAt(j-1) == target.charAt(j-1)) dp[0][j] = true;
            else break;
        }

        for(int i = 1; i <= n1; i++){
            for(int j = 1; j <= n2; j++){
                if(dp[i-1][j] && str1.charAt(i-1) == target.charAt(i+j-1)){
                    dp[i][j] = true;
                }
                else if(dp[i][j-1] && str2.charAt(j-1) == target.charAt(i+j-1)){
                    dp[i][j] = true;
                }
            }
        }

        return dp[n1][n2];
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
