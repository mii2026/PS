import java.util.*;
import java.io.*;

class Main {

    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    public class Node{
        int x, y, depth, block;

        public Node(int x, int y, int depth, int block){
            this.x = x;
            this.y = y;
            this.depth = depth;
            this.block = block;
        }
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        char[][] map = new char[n][m];
        for(int i = 0; i < n; i++){
            map[i] = br.readLine().toCharArray();
        }

        boolean[][][] visited = new boolean[n][m][11];
        Queue<Node> q = new LinkedList<>();

        q.add(new Node(0, 0, 1, 0));
        visited[0][0][0] = true;

        while(!q.isEmpty()){
            Node cur = q.poll();

            if(cur.x == (n-1) && cur.y == (m-1)){
                System.out.print(cur.depth);
                return;
            }

            for(int i = 0; i < 4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m)
                    continue;

                if(map[nx][ny] == '1' && cur.depth % 2 == 0){
                    q.add(new Node(cur.x, cur.y, cur.depth+1, cur.block));
                }
                else if(map[nx][ny] == '1' && cur.block < k){
                    if(visited[nx][ny][cur.block+1])
                        continue;
                    visited[nx][ny][cur.block+1] = true;
                    q.add(new Node(nx, ny, cur.depth+1, cur.block+1));
                }
                else if(map[nx][ny] == '0'){
                    if(visited[nx][ny][cur.block])
                        continue;
                    visited[nx][ny][cur.block] = true;
                    q.add(new Node(nx, ny, cur.depth+1, cur.block));
                }
            }
        }

        System.out.print(-1);
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}