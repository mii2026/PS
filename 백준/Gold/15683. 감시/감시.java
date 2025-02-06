import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    int N, M, answer;
    int[][] map;
    List<int[]> cctvs = new ArrayList<>();
    int[] types;

    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    int[][][] cctvModes = {
            {},
            {{0}, {1}, {2}, {3}},
            {{0, 2}, {1, 3}},
            {{0, 1}, {1, 2}, {2, 3}, {3, 0}},
            {{0, 1, 2}, {0, 1, 3}, {0, 2, 3}, {1, 2, 3}},
            {{0, 1, 2, 3}}
    };

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = N * M;
        
        map = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] >= 1 && map[i][j] <= 5) {
                    cctvs.add(new int[]{i, j, map[i][j]});
                }
            }
        }
        types = new int[cctvs.size()];
        
        dfs(0);
        System.out.print(answer);
    }

    public void dfs(int index) {
        if(index == cctvs.size()) {
            int[][] backup = copy();
            for(int i = 0; i < cctvs.size(); i++) {
                int[] cctv = cctvs.get(i);
                
                for(int dir: cctvModes[cctv[2]][types[i]]) {
                    check(cctv[0], cctv[1], dir);
                }
            }
            
            answer = Math.min(answer, countBlindSpots());
            
            map = backup;
            return;
        }

        int[] cctv = cctvs.get(index);
        int type = cctv[2];
        for (int i = 0; i < cctvModes[type].length; i++) {
            types[index] = i;
            dfs(index + 1);
        }
    }

    void check(int x, int y, int dir) {
        while (x >= 0 && y >= 0 && x < N && y < M) {
            x += dx[dir];
            y += dy[dir];
            
            if (x < 0 || y < 0 || x >= N || y >= M || map[x][y] == 6) {
                break;
            }
            
            if (map[x][y] == 0) {
                map[x][y] = -1;
            }
        }
    }

    int countBlindSpots() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) count++;
            }
        }
        return count;
    }

    int[][] copy() {
        int[][] copy = new int[N][M];
        for (int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                copy[i][j] = map[i][j];
            }
        }
        return copy;
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}