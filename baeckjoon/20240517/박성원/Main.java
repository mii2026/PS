// https://www.acmicpc.net/problem/1086

import java.io.BufferedReader;
import java.io.InputStreamReader;;

public class Main {
    int n, k, maxBit;
    int[][] remains;
    long[][] dp;

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        String[] nums = new String[n];
        for(int i = 0; i < n; i++){
            nums[i] = new StringBuffer(br.readLine()).reverse().toString();
        }
        k = Integer.parseInt(br.readLine());
        
        int[] mod10 = new int[51];
        mod10[0] = 1 % k;
        for(int i = 1; i <= 50; i++){
            mod10[i] = (mod10[i - 1] * 10) % k;
        } 
  
        remains = new int[n][2];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < nums[i].length(); j++){
                remains[i][0] += ((nums[i].charAt(j)-'0') * mod10[j]);
            }
            remains[i][0] %= k;
            remains[i][1] = mod10[nums[i].length()];
        }

        maxBit = (1 << n) - 1;
        dp = new long[k][maxBit];
        for(int i = 0; i < k; i++){
            for(int j = 0; j < maxBit; j++){
                dp[i][j] = -1;
            }
        }
        
        long p = dfs(0, 0);
        long q = factorial(n);
        long gcd = gcd(p, q);

        System.out.print((p/gcd) + "/" + (q/gcd));
    }

    public long dfs(int x, int visited){
        if(visited == maxBit){
            return (x == 0) ? 1 : 0;
        }

        if(dp[x][visited] != -1)
            return dp[x][visited];

        dp[x][visited] = 0;
        
        for(int i = 0; i < n; i++){
            if((visited & (1 << i)) != 0)
                continue;
            
            int nvisited = visited | (1 << i);
            int nx = (x * remains[i][1] + remains[i][0]) % k; 

            dp[x][visited] += dfs(nx, nvisited);
        }

        return dp[x][visited];
    }

    public long factorial(final int x){
        long result = 1;
        for(int i = 1; i <= x; i++){
            result *= i;
        }
        return result;
    }

    public long gcd(long x, long y){
        if(x % y == 0)
            return y;
        return gcd(y, x % y);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}