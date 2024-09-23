// https://school.programmers.co.kr/learn/courses/30/lessons/169199

import java.util.*;

class Solution {
    
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    
    class Node{
        int x, y, depth;
        
        public Node(int x, int y, int depth){
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }
    
    public int solution(String[] board) {
        int n = board.length;
        int m = board[0].length();
        boolean[][] visited = new boolean[n][m];
        Queue<Node> q = new LinkedList<>();
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i].charAt(j) == 'R'){
                    q.add(new Node(i, j, 0));
                    visited[i][j] = true;
                    break;
                }
            }
        }
        
        while(!q.isEmpty()){
            Node cur = q.poll();
            
            if(board[cur.x].charAt(cur.y) == 'G'){
                q.clear();
                return cur.depth;
            }
            
            for(int i = 0; i < 4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                
                while(nx >= 0 && nx < n && ny >= 0 && ny < m &&
                      board[nx].charAt(ny) != 'D'){
                    nx += dx[i];
                    ny += dy[i];
                }
                
                nx -= dx[i];
                ny -= dy[i];
                
                if(visited[nx][ny])
                    continue;
                
                q.add(new Node(nx, ny, cur.depth+1));
                visited[nx][ny] = true;
            }
        }
        
        return -1;
    }
}
