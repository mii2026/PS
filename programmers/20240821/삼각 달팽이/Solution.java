// https://school.programmers.co.kr/learn/courses/30/lessons/68645

class Solution {
    public int[] solution(int n) {
        int[] dx = {1, 0, -1};
        int[] dy = {0, 1, -1};
        int[][] arr = new int[n][n];
        
        int x = n - 1;
        int y = 0;      
        int num = n + 1;
        for(int i = 0; i < n; i++){
            arr[i][0] = i + 1;
        }
        for(int i = 1; i < n; i++){
            int dir = i % 3;
            for(int j = 0; j < n - i; j++){
                x += dx[dir];
                y += dy[dir];
                arr[x][y] = num++;
            }
        }
        
        num = 0;
        int[] answer = new int[n * (n+1) / 2];
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                answer[num++] = arr[i][j];
            }
        }
        return answer;
    }
}
