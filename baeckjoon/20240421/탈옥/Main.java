// https://www.acmicpc.net/problem/9376import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public class EscapeSimul{
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        char[][] map;
        int[][] count;
        boolean[][] visited;
        int x1, x2, y1, y2;
        int h, w;

        public EscapeSimul(
            char[][] map, int[][] count, int x1, int x2, int y1, int y2
        ){
            this.map = map;
            this.count = count;
            this.x1 = x1;
            this.x2 = x2;
            this.y1 = y1;
            this.y2 = y2;
            this.h = map.length;
            this.w = map[0].length;
        }

        public int minDoor(){
            bfs(0, 0);
            bfs(x1, y1);
            bfs(x2, y2);

            int ans = 10000;
            for(int i = 1; i < h-1; i++){
                for(int j = 1; j < w-1; j++){
                    if(map[i][j] == '*')
                        continue;

                    if(map[i][j] == '#')
                        count[i][j] -= 2;

                    if(visited[i][j] && ans > count[i][j])
                        ans = count[i][j];
                }
            }
            return ans;
        }

        public void bfs(int x, int y){
            visited = new boolean[h+2][w+2];
            PriorityQueue<Node> q = new PriorityQueue<>((i,j) -> i.count - j.count);
            
            q.add(new Node(x, y, 0));
            visited[x][y] = true;
            
            while(!q.isEmpty()){
                Node cur = q.poll();

                for(int i = 0; i < 4; i++){
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];
                    int ncount = cur.count;

                    if(nx < 0 || nx >= h || ny < 0 || ny >= w || visited[nx][ny] || map[nx][ny] == '*'){
                        continue;
                    }

                    if(map[nx][ny] == '#')
                        ncount++;

                    visited[nx][ny] = true;
                    q.add(new Node(nx, ny, ncount));
                    count[nx][ny] += ncount;
                }
            }
        }
    }

    public class Node{
        int x, y, count;

        public Node(int x, int y, int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int test = 0; test < n; test++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            char[][] map = new char[h+2][w+2];
            int x1 =0;
            int x2 = 0;
            int y1 = 0;
            int y2 = 0;

            for(int i = 1; i <= h; i++){
                String str = br.readLine();
                for(int j = 1; j <= w; j++){
                    map[i][j] = str.charAt(j-1);

                    if(map[i][j] == '$' && y1 == 0){
                        x1 = i;
                        y1 = j;
                    }else if(map[i][j] == '$'){
                        x2 = i;
                        y2 = j;
                    }
                }
            }

            EscapeSimul simul = new EscapeSimul(map, new int[h+2][w+2], x1, x2, y1, y2);
            sb.append(simul.minDoor()).append("\n");
        }

        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
​