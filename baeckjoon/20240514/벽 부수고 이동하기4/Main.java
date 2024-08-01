// https://www.acmicpc.net/problem/16946

import java.util.*;
import java.io.*;

class Main {
    ArrayList<Integer> group = new ArrayList<>();
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    
    char[][] map;
    int[][] visited;
    int n, m;

    class Node{
        int x, y;

        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    void grouping(int x, int y, int gnum){
        Queue<Node> q = new LinkedList<>();
        int num = 1;

        q.add(new Node(x, y));
        visited[x][y] = gnum;

        while(!q.isEmpty()){
            Node cur = q.poll();
            
            for(int i = 0; i < 4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;

                if(map[nx][ny] == '0' && visited[nx][ny] == 0){
                    q.add(new Node(nx, ny));
                    visited[nx][ny] = gnum;
                    num++;
                }
            }
        }

        group.add(num);
    }
    
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visited = new int[n][m];

        for(int i = 0; i < n; i++){
            map[i] =  br.readLine().toCharArray();
        }

        int gnum = 1;
        group.add(0);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == '0' && visited[i][j] == 0){
                    grouping(i, j, gnum++);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        boolean[] gcheck = new boolean[group.size()];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == '1'){
                    int result = 1;
                    for(int k = 0; k < 4; k++){
                        int nx = i + dx[k];
                        int ny = j + dy[k];
            
                        if(nx < 0 || nx >= n || ny < 0 || ny >= m || map[nx][ny] == '1')
                            continue;
            
                        if(!gcheck[visited[nx][ny]]){
                            gcheck[visited[nx][ny]] = true;
                            result += group.get(visited[nx][ny]);
                        }
                    }
                    sb.append(result % 10);
                    Arrays.fill(gcheck, false);
                }else{
                    sb.append(0);
                }
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
  
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
​