// https://www.acmicpc.net/problem/2933

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public class Cave{
        int r, c;
        char[][] map;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        
        public Cave(int r, int c, char[][] map){
            this.r = r;
            this.c = c;
            this.map = map;
        }

        public void throwStick(int dir, int h){
            breakMineral(dir, h);
            dropMineral();
        }

        public void breakMineral(int dir, int h){
            if(dir == 0){
                for(int i = 0; i < c; i++){
                    if(map[h][i] == 'x'){
                        map[h][i] = '.';
                        break;
                    } 
                }
            }
            else if(dir == 1){
                for(int i = c-1; i>=0; i--){
                    if(map[h][i] == 'x'){
                        map[h][i] = '.';
                        break;
                    }
                }
            }
        }

        public void dropMineral(){
            boolean[][] visited = new boolean[r][c];
            Queue<int[]> q = new LinkedList<>();
            ArrayList<int[]> cluster = new ArrayList<>();

            for(int i = 0; i < c; i++){
                if(map[0][i] == '.' || visited[0][i])
                    continue;

                q.add(new int[]{0, i});
                visited[0][i] = true;

                while(!q.isEmpty()){
                    int[] cur = q.poll();
    
                    for(int j = 0; j < 4; j++){
                        int nx = cur[0] + dx[j];
                        int ny = cur[1] + dy[j];
    
                        if(nx>=0 && nx<r && ny>=0 && ny<c && map[nx][ny] == 'x' && !visited[nx][ny]){
                            q.add(new int[]{nx, ny});
                            visited[nx][ny] = true;
                        }
                    }
                }
            }

            for(int i = 0; i < r; i++){
                for(int j = 0; j < c; j++){
                    if(!visited[i][j] && map[i][j] == 'x'){
                        map[i][j] = '.';
                        cluster.add(new int[]{i, j});
                    }
                }
            }

            if(cluster.isEmpty()){
                return;
            }

            int min = 0;
            for(int i = 1; i < r; i++){
                for(int[] pos: cluster){
                    int nx = pos[0] - i;
                    int ny = pos[1];

                    if(nx < 0 || map[nx][ny] == 'x'){
                        min = i - 1;
                        break;
                    }
                }
                if(min>0){
                    break;
                }
            }

            for(int[] pos: cluster){
                map[pos[0]-min][pos[1]] = 'x';
            }
        }
    }

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        char[][] map = new char[r][c];

        for(int i = r-1; i >= 0; i--){
            map[i] = br.readLine().toCharArray();
        }

        Cave cave = new Cave(r, c, map);

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            int h = Integer.parseInt(st.nextToken());
            cave.throwStick(i % 2, h-1);
        }

        map = cave.map;
        StringBuilder sb = new StringBuilder();
        for(int i = r-1; i >= 0; i--){
            for(int j = 0; j < c; j++){
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
