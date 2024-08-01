// https://www.acmicpc.net/problem/1956

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    final int inf = 1000000000;

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int[][] map = new int[v][v];
        
        for(int i = 0; i < v; i++){
            for(int j = 0; j < v; j++){
                map[i][j] = inf;
            }
        }

        for(int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int dis = Integer.parseInt(st.nextToken());

            map[a][b] = dis;
        }

        for(int i = 0; i < v; i++){
            for(int j = 0; j < v; j++){
                for(int k = 0; k < v; k++){
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }

        int ans = inf;
        for(int i = 0; i < v; i++){
            ans = Math.min(ans, map[i][i]);
        }

        System.out.print(ans == inf ? -1 : ans);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
