// https://www.acmicpc.net/problem/9252

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        char[] str1 = br.readLine().toCharArray();
        char[] str2 = br.readLine().toCharArray();
        
        int n = str1.length;
        int m = str2.length;
        int[][] dp = new int[m+1][n+1];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(str1[j] == str2[i]){
                    dp[i+1][j+1] = dp[i][j] + 1;
                }else{
                    dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(dp[m][n]).append("\n");

        int x = n;
        int y = m;
        Stack<Character> stack = new Stack<>();
        while(x > 0 && y > 0){
            if(dp[y-1][x] == dp[y][x])
                y--;
            else if(dp[y][x-1] == dp[y][x])
                x--;
            else{
                stack.push(str1[x-1]);
                x--;
                y--;
            }
        }

        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
​