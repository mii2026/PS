// https://www.acmicpc.net/problem/2151

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    class Node{
        int x, y, dir, mirror;

        Node(int x, int y, int dir, int mirror){
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.mirror = mirror;
        }
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        char[][] arr = new char[n][n];
        boolean[][][] visited = new boolean[n][n][4];
        int x = 0, y = 0;

        for(int i = 0; i < n; i++){
            arr[i] = br.readLine().toCharArray();
            for(int j = 0; j < n; j++){
                if(arr[i][j] == '#'){
                    x = i;
                    y = j;
                }
                if(arr[i][j] == '*'){
                }
            }
        }

        PriorityQueue<Node> q = new PriorityQueue<>((i, j) -> i.mirror - j.mirror);

        for(int i = 0; i < 4; i++){
            visited[x][y][i] = true;
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny][i] && arr[nx][ny] != '*')
                q.add(new Node(nx, ny, i, 0));
        }

        while(!q.isEmpty()){
            Node cur = q.poll();
            // System.out.print(cur.x + " " + cur.y);

            if(visited[cur.x][cur.y][cur.dir])
                continue;

            if(arr[cur.x][cur.y] == '#'){
                System.out.print(cur.mirror);
                break;
            }
           
            visited[cur.x][cur.y][cur.dir] = true;

            int nx = cur.x + dx[cur.dir];
            int ny = cur.y + dy[cur.dir];

            if(nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny][cur.dir] && arr[nx][ny] != '*'){
                q.add(new Node(nx, ny, cur.dir, cur.mirror));
            }

            if(arr[cur.x][cur.y] == '!'){
                for(int i = 1; i < 4; i+=2){
                    int ndir = (cur.dir + i) % 4;
                    nx = cur.x + dx[ndir];
                    ny = cur.y + dy[ndir];

                    if(nx >= 0 && nx < n && ny >= 0 && ny < n  && !visited[nx][ny][ndir] && arr[nx][ny] != '*'){
                        q.add(new Node(nx, ny, ndir, cur.mirror + 1));
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}