// https://www.acmicpc.net/problem/2186

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    int n, m, k;
    char[][] arr;
    int[][][] dp;
    String target;

    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new char[n][m];

        for(int i = 0; i < n; i++){
            arr[i] = br.readLine().toCharArray();
        }

        target = br.readLine();
        dp = new int[n][m][target.length()];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                for(int k = 0; k < target.length(); k++){
                    dp[i][j][k] = -1;
                }
            }
        }

        int answer = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(arr[i][j] == target.charAt(0))
                    answer += dfs(i, j, 0);
            }
        }

        System.out.print(answer);
    }

    public int dfs(int x, int y, int depth){
        if(depth == target.length() - 1)
            return 1;
        if(dp[x][y][depth] != -1)
            return dp[x][y][depth];

        dp[x][y][depth] = 0;

        for(int i = 1; i <= k; i++){
            for(int j = 0; j < 4; j++){
                int nx = x + i * dx[j];
                int ny = y + i * dy[j];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;

                if(arr[nx][ny] == target.charAt(depth+1))
                    dp[x][y][depth] += dfs(nx, ny, depth+1);
            }
        }

        return dp[x][y][depth];
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
​