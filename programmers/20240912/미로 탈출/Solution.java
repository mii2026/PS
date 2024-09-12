// https://school.programmers.co.kr/learn/courses/30/lessons/159993

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
    
    public int solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        
        boolean[][] visited = new boolean[n][m];
        Queue<Node> q = new LinkedList<>();
        boolean open = false;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps[i].charAt(j) == 'S') {
                    q.add(new Node(i, j, 0));
                    visited[i][j] = true;
                    break;
                }
            }
        }
        
        while (!q.isEmpty()) {
            Node cur = q.poll();
            
            if (open && maps[cur.x].charAt(cur.y) == 'E') {
                return cur.depth;
            } else if (!open && maps[cur.x].charAt(cur.y) == 'L') {
                open = true;
                q.clear();
                visited = new boolean[n][m];
                visited[cur.x][cur.y] = true;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                
                if (nx < 0 || ny < 0 || nx >= n || ny >=m) 
                    continue;
                
                if(visited[nx][ny] || maps[nx].charAt(ny) == 'X')
                    continue;
                
                q.add(new Node(nx, ny, cur.depth+1));
                visited[nx][ny] = true;
            }
        }
        
        return -1;
    }
}
