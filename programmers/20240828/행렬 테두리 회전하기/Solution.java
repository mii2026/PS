// https://school.programmers.co.kr/learn/courses/30/lessons/77485

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] arr = new int[rows][columns];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                arr[i][j] = i * columns + j + 1;
            }
        }
        
        int[] answer = new int[queries.length];
        for(int q = 0; q < queries.length; q++){
            int first = arr[queries[q][0]-1][queries[q][1]-1];
            int min = first;
            
            for(int i = queries[q][0]; i < queries[q][2]; i++){
                arr[i-1][queries[q][1]-1] = arr[i][queries[q][1]-1];
                min = Math.min(min, arr[i][queries[q][1]-1]);
            }
            
            for(int i = queries[q][1]; i < queries[q][3]; i++){
                arr[queries[q][2]-1][i-1] = arr[queries[q][2]-1][i];
                min = Math.min(min, arr[queries[q][2]-1][i-1]);
            }
            
            for(int i = queries[q][2] - 2; i >= queries[q][0] - 1; i--){
                arr[i+1][queries[q][3]-1] = arr[i][queries[q][3]-1];
                min = Math.min(min, arr[i][queries[q][3]-1]);
            }
            
            for(int i = queries[q][3] - 2; i >= queries[q][1]; i--){
                arr[queries[q][0]-1][i+1] = arr[queries[q][0]-1][i];
                min = Math.min(min, arr[queries[q][0]-1][i]);
            }
            
            arr[queries[q][0]-1][queries[q][1]] = first;
            answer[q] = min;
        }
        
        return answer;
    }
}
