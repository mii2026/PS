import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] map = new char[n][m];

        for(int i = 0; i < n; i++) {
            char[] line = br.readLine().toCharArray();
            for(int j = 0; j < m; j++) {
                map[i][j] = line[j];
            }
        }

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        Queue<Node> q = new LinkedList<>();
        boolean[][][] visited = new boolean[n][m][2];

        q.add(new Node(0, 0, 1, false));
        visited[0][0][0] = true;

        while(!q.isEmpty()) {
            Node cur = q.poll();
            int wall = cur.wall ? 1 : 0;

            if(cur.x == n - 1 && cur.y == m - 1) {
                System.out.print(cur.depth);
                return;
            }

            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m)
                    continue;

                if(map[nx][ny] == '0' && !visited[nx][ny][wall]) {
                    visited[nx][ny][wall] = true;
                    q.add(new Node(nx, ny, cur.depth + 1, cur.wall));
                }

                if(map[nx][ny] == '1' && wall == 0 && !visited[nx][ny][1]) {
                    visited[nx][ny][1] = true;
                    q.add(new Node(nx, ny, cur.depth + 1, true));
                }
            }
        }

        System.out.print(-1);
    }

    class Node {
        int x, y, depth;
        boolean wall;

        Node(int x, int y, int depth, boolean wall) {
            this.x = x;
            this.y = y;
            this.depth = depth;
            this.wall = wall;
        }
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}