import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

class Main {

    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    public class Node{
        int num, x, y;
        long time;

        Node(int x, int y, long time, int num){
            this.x = x;
            this.y = y;
            this.time = time;
            this.num = num;
        }
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];

        // map 입력
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 알파벳 위치 입력
        int[][] chars = new int[5][2];
        for(int i = 0; i < 5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            chars[i][0] = Integer.parseInt(st.nextToken()) - 1;
            chars[i][1] = Integer.parseInt(st.nextToken()) - 1;
        }

        // 다익스트라 실행
        long answer = Long.MAX_VALUE;

        for(int a = 0; a < 2; a++){
            boolean[][][] visited = new boolean[n][n][5];
            PriorityQueue<Node> q = new PriorityQueue<>((i, j) -> Long.compare(i.time, j.time));
            
            q.add(new Node(0, 0, 0, 0));

            while(!q.isEmpty()){
                Node cur = q.poll();
                int num = cur.num;
                int x = cur.x;
                int y = cur.y;

                if(chars[num][0] == x && chars[num][1] == y){
                    num++;
                    q.clear();
                }

                if(num == 5){
                    answer = Math.min(answer, cur.time);
                    break;
                }

                if(visited[x][y][num])
                    continue;

                visited[x][y][num] = true;

                for(int dir = 0; dir < 4; dir++){
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];

                    if(nx < 0 || ny < 0 || nx >= n || ny >= n)
                        continue;

                    if(visited[nx][ny][num])
                        continue;

                    long ntime = cur.time + map[cur.x][cur.y] + map[nx][ny];

                    q.add(new Node(nx, ny, ntime, num));
                }
            }

            int temp = chars[0][0];
            chars[0][0] = chars[4][0];
            chars[4][0] = temp;

            temp = chars[0][1];
            chars[0][1] = chars[4][1];
            chars[4][1] = temp;
        }

        System.out.print(answer);        
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}