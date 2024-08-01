// https://www.acmicpc.net/problem/16954

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    class Node{
        int x, y, depth;

        Node(int x, int y, int depth){
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        char[][] map = new char[8][8];
        ArrayList<Node> walls = new ArrayList<>();

        for(int i = 0; i < 8; i++){
            map[i] = br.readLine().toCharArray();
            for(int j = 0; j < 8; j++){
                if(map[i][j] == '#'){
                    walls.add(new Node(i, j, 0));
                }
            }
        }

        int[] dx = {0, 0, 0, 1, 1, 1, -1, -1, -1};
        int[] dy = {0, 1, -1, 0, 1, -1, 0, 1, -1};
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(7, 0, 0));

        for(int i = 0; i < 8; i++){
            while(!q.isEmpty() && q.peek().depth == i){
                Node cur = q.poll();

                for(int j = 0; j < 9; j++){
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];
                    
                    if(nx < 0 || ny < 0 || nx >= 8 || ny >= 8 || map[nx][ny] == '#')
                        continue;

                    if(nx > 0 && map[nx-1][ny] == '#')
                        continue;

                    q.add(new Node(nx, ny, i+1));
                }
            }

            for(int j = walls.size()-1; j >= 0; j--){
                Node w = walls.get(j);
                map[w.x][w.y] = '.';

                if(w.x == 7){
                    walls.remove(w);
                }else{
                    w.x++;
                    map[w.x][w.y] = '#';
                }
            }

            
            if(q.isEmpty() || walls.isEmpty()){
                break;
            }
        }

        System.out.print(q.isEmpty() ? 0 : 1);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}