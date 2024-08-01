// https://school.programmers.co.kr/learn/courses/30/lessons/250134

class Solution {
    int n, m;
    int[][] maze;
    boolean[][] visited1;
    boolean[][] visited2;
    
    int answer = 100;
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    
    public int solution(int[][] maze) {
        this.maze = maze;
        n = maze.length;
        m = maze[0].length;
        visited1 = new boolean[n][m];
        visited2 = new boolean[n][m];
        
        int x1 = 0;
        int y1 = 0;
        int x2 = 0;
        int y2 = 0;
       	for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(maze[i][j] == 1){
                    x1 = i;
                    y1 = j;
                    visited1[i][j] = true;
                }else if(maze[i][j] == 2){
                    x2= i;
                    y2 = j;
                    visited2[i][j] = true;
                }
            }
        }
        
        dfs(x1, y1, x2, y2, 0);
        return answer == 100 ? 0 : answer;
    }
    
    void dfs(int x1, int y1, int x2, int y2, int depth){
        if(maze[x1][y1] == 3 && maze[x2][y2] == 4){
            answer = Math.min(answer, depth);
        }
        else if(maze[x1][y1] == 3){
            for(int i = 0; i < 4; i++){
                int nx2 = x2 + dx[i];
                int ny2 = y2 + dy[i];
                
                if(nx2 < 0 || nx2 >= n || ny2 < 0 || ny2 >= m)
                    continue;
                
                if(maze[nx2][ny2] == 5 || visited2[nx2][ny2])
                    continue;
                
                if(x1 == nx2 && y1 == ny2)
                    continue;
                
                visited2[nx2][ny2] = true;
                dfs(x1, y1, nx2, ny2, depth+1);
                visited2[nx2][ny2] = false;
            }
        }
        else if(maze[x2][y2] == 4){
            for(int i = 0; i < 4; i++){
                int nx1 = x1 + dx[i];
                int ny1 = y1 + dy[i];
                
                if(nx1 < 0 || nx1 >= n || ny1 < 0 || ny1 >= m)
                    continue;
                
                if(maze[nx1][ny1] == 5 || visited1[nx1][ny1])
                    continue;
                
                if(x2 == nx1 && y2 == ny1)
                    continue;
                
                visited1[nx1][ny1] = true;
                dfs(nx1, ny1, x2, y2, depth+1);
                visited1[nx1][ny1] = false;
            }
        }
        else{
            for(int i = 0; i < 4; i++){
                int nx1 = x1 + dx[i];
                int ny1 = y1 + dy[i];
                
                if(nx1 < 0 || nx1 >= n || ny1 < 0 || ny1 >= m)
                    continue;
                
                if(maze[nx1][ny1] == 5 || visited1[nx1][ny1])
                    continue;
                
                visited1[nx1][ny1] = true;
                for(int j = 0; j < 4; j++){
                    int nx2 = x2 + dx[j];
                    int ny2 = y2 + dy[j];

                    if(nx2 < 0 || nx2 >= n || ny2 < 0 || ny2 >= m)
                        continue;

                    if(maze[nx2][ny2] == 5 || visited2[nx2][ny2])
                        continue;

                    if(x1 == nx2 && y1 == ny2 && nx1 == x2 && ny1 == y2)
                        continue;
     
                    if(nx1 == nx2 && ny1 == ny2)
                        continue;

                    visited2[nx2][ny2] = true;
                    dfs(nx1, ny1, nx2, ny2, depth+1);
                    visited2[nx2][ny2] = false;
            	}
                visited1[nx1][ny1] = false;
            }
        }
    }
}
​