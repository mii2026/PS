// https://www.acmicpc.net/problem/4991

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    public class Node{
        int x, y, visit, bit;

        public Node(int x, int y, int visit, int bit){
            this.x = x;
            this.y = y;
            this.visit = visit;
            this.bit = bit;
        }
    }

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        Queue<Node> q = new LinkedList<>();

        while(true){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            if(w==0 && h==0){
                break;
            }
            
            char[][] map = new char[h][w];
            Node start = new Node(0, 0, 0, 0);
            int k = 0;

            for(int i = 0; i < h; i++){
                map[i] = br.readLine().toCharArray();
                for(int j = 0; j < w; j++){
                    if(map[i][j]=='*'){
                        map[i][j] = (char)(k++ + '0');
                    }
                    else if(map[i][j]=='o'){
                        start.x = i;
                        start.y = j;
                        map[i][j] = '.';
                    }
                }
            }

            boolean[][][] visited = new boolean[h][w][1<<k];
            int targetBit = (1<<k) - 1;
            int answer = -1;
            q.add(start);

            while(!q.isEmpty()){
                Node cur = q.poll();

                for(int i = 0; i < 4; i++){
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];
                    int bit = cur.bit;

                    if(nx < 0 || nx >= h || ny < 0 || ny >= w || map[nx][ny] == 'x'){
                        continue;
                    }
                    
                    if(Character.isDigit(map[nx][ny])){
                        bit |= 1<<(map[nx][ny]-'0');
                        
                        if(bit == targetBit){
                            q.clear();
                            answer = cur.visit + 1;
                            break;
                        }
                    }

                    if(visited[nx][ny][bit]){
                        continue;
                    }

                    visited[nx][ny][bit] = true;
                    q.add(new Node(nx, ny, cur.visit + 1, bit));
                }
            }

            sb.append(answer).append("\n");
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
