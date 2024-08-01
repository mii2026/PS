// https://www.acmicpc.net/problem/2098

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    final int inf = 1000000000;
    int n, fullBit;
    int[][] map;
    int[][] dp;

    void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        fullBit = (1 << n) - 1;
        map = new int[n][n];
        dp = new int[n][fullBit];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < fullBit; j++){
                dp[i][j] = -1;
            }
        }

        System.out.print(tsp(0, 1));
    }

    int tsp(int x, int visited){
        if(visited == fullBit){
            if(map[x][0] ==  0)
                return inf;
            else
                return map[x][0];
        }

        if(dp[x][visited] != -1)
            return dp[x][visited];
        
        dp[x][visited] = inf;

        for(int i = 0; i < n; i++){
            if((visited & (1 << i)) != 0)
                continue;

            if(map[x][i] == 0)
                continue;

            int next = visited | (1 << i);

            dp[x][visited] = Math.min(dp[x][visited], map[x][i] + tsp(i, next));
        }

        return dp[x][visited];
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
