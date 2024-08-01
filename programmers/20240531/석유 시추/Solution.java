// https://school.programmers.co.kr/learn/courses/30/lessons/250136

import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int[][] land) {
        int n = land.length;
        int m = land[1].length;
        
        boolean[][] visited = new boolean[n][m];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int[] groups = new int[n*m];
        int g = 2;
        
        for(int i = 0; i < n; i++){
        	for(int j = 0; j < m; j++){
                if(land[i][j] == 1){
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i, j});
                    land[i][j] = g;
                    groups[g]++;
                    
                    while(!q.isEmpty()){
                        int[] cur = q.poll();
                        
                        for(int k = 0; k < 4; k++){
                            int nx = cur[0] + dx[k];
                            int ny = cur[1] + dy[k];
                            
                            if(nx < 0 || nx >= n || ny < 0 || ny >= m)
                                continue;
                            
                            if(land[nx][ny] == 1){
                                q.add(new int[]{nx, ny});
                                visited[nx][ny] = true;
                                land[nx][ny] = g;
                                groups[g]++;
                            }
                        }
                    }
                    
                    g++;
                }
            }    
        }
        
        int answer = 0;
        for(int j = 0; j < m; j++){
            int temp = 0;
            boolean[] gcheck = new boolean[g];
            for(int i = 0; i < n; i++){
                if(land[i][j] != 0 && !gcheck[land[i][j]]){
                    temp += groups[land[i][j]];
                    gcheck[land[i][j]] = true;
                }
            }
            answer = Math.max(answer, temp);
        }
        return answer;
    }
}