// https://school.programmers.co.kr/learn/courses/30/lessons/154540

import java.util.*;

class Solution {
    public boolean[][] visited;
    public int n, m;
    
    public int[] dx = {1, 0, -1, 0};
    public int[] dy = {0, 1, 0, -1};
    
    public int[] solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        visited = new boolean[n][m];
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(maps[i].charAt(j) != 'X' && !visited[i][j]){
                    int result = bfs(maps, i, j);
                    list.add(result);
                }
            }
        }
        
        if(list.size() == 0){
            return new int[]{-1};
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
    
    public class Node{
        int x, y;
        
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public int bfs(String[] maps, int x, int y){
        Queue<Node> q = new LinkedList<>();
        int result = 0;
        
        q.add(new Node(x, y));
        visited[x][y] = true;
        
        while(!q.isEmpty()){
            Node cur = q.poll();
            result += (maps[cur.x].charAt(cur.y) - '0');
            
            for(int i = 0; i < 4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                
                if(nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;
                
                if(visited[nx][ny] || maps[nx].charAt(ny) == 'X')
                    continue;
                
                q.add(new Node(nx, ny));
                visited[nx][ny] = true;
            }
        }
        
        return result;
    }
    
}
