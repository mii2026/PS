// https://school.programmers.co.kr/learn/courses/30/lessons/68936

class Solution {
    private int[] answer = new int[2];
    
    public int[] solution(int[][] arr) {
        divide(arr, 0, 0, arr.length);
        return answer;
    }
    
    public void divide(int[][] arr, int x, int y, int len){
        if(len == 1){
            answer[arr[x][y]]++;
            return;
        }
        
        boolean check = true;
        for(int i = x; i < x + len; i++){
            for(int j = y; j < y + len; j++){
                if(arr[x][y] != arr[i][j]){
                    check = false;
                    break;
                }
            }
        }
        
        if(check){
            answer[arr[x][y]]++;
            return;
        }
            
        int nlen = len / 2;
        divide(arr, x, y, nlen);
        divide(arr, x + nlen, y, nlen);
        divide(arr, x, y + nlen, nlen);
        divide(arr, x + nlen, y + nlen, nlen);
    }
}
