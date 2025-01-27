import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    class Node {
        int x, y, time;

        Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        char[][] arr = new char[r][c];

        int[][] fireDists = new int[r][c];
        boolean[][] visited = new boolean[r][c];
        Queue<Node> fireQ = new LinkedList<>();
        Queue<Node> personQ = new LinkedList<>();

        for(int i = 0; i < r; i++) {
            char[] tmp = br.readLine().toCharArray();
            for(int j = 0; j < c; j++) {
                arr[i][j] = tmp[j];
                fireDists[i][j] = 10000000;

                if(arr[i][j] == 'F') {
                    fireQ.add(new Node(i, j, 0));
                    fireDists[i][j] = 0;
                } else if(arr[i][j] == 'J') {
                    personQ.add(new Node(i, j, 0));
                }
            }
        }

        while(!fireQ.isEmpty()) {
            Node cur = fireQ.poll();
            
            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= r || ny >= c) continue;

                if(fireDists[nx][ny] != 10000000 || arr[nx][ny] == '#') continue;

                fireDists[nx][ny] = cur.time + 1;
                fireQ.add(new Node(nx, ny, cur.time + 1));
            }
        }

        while(!personQ.isEmpty()) {
            Node cur = personQ.poll();

            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= r || ny >= c) {
                    System.out.print(cur.time + 1);
                    return;
                }

                if(fireDists[nx][ny] <= cur.time + 1 || arr[nx][ny] == '#' || visited[nx][ny]) 
                    continue;

                visited[nx][ny] = true;
                personQ.add(new Node(nx, ny, cur.time + 1));
            }
        }

        System.out.print("IMPOSSIBLE");
    }

    public void personMove(Node node) {
        
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}