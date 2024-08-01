import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class Main {
    public class Node{
        int x, y, mirror, dir;

        public Node(int x, int y, int dir, int mirror){
            this.x = x;
            this.y = y;
            this.mirror = mirror;
            this.dir = dir;
        }
    }

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        char[][] map = new char[h][w];
        Node start = new Node(0, 0, -1, 0);

        for(int i = 0; i < h; i++){
            map[i] = br.readLine().toCharArray();
            for(int j = 0; j < w; j++){
                if(map[i][j] == 'C'){
                    start.x = i;
                    start.y = j;
                }
            }
        }

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        boolean[][] visited = new boolean[h][w];

        PriorityQueue<Node> q = new PriorityQueue<>((i,j) -> i.mirror - j.mirror);
        q.add(start);

        int answer = 10000;
        
        while(!q.isEmpty()){
            Node cur = q.poll();
            visited[cur.x][cur.y] = true;

            for(int i = 0; i < 4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                int mirror = cur.mirror;

                if(nx < 0 || nx >= h || ny < 0 || ny >= w || visited[nx][ny] || map[nx][ny] == '*'){
                    continue;
                }

                if(cur.dir != -1 && cur.dir != i){
                    mirror++;
                }

                if(map[nx][ny] == 'C'){
                    answer = Math.min(answer, mirror);
                    break;
                }

                q.add(new Node(nx, ny, i, mirror));
            }
        }

        System.out.print(answer);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
