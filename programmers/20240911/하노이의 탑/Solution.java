// https://school.programmers.co.kr/learn/courses/30/lessons/12946

class Solution {
    
    int[][] answer;
    int idx;
    
    public int[][] solution(int n) {
        answer = new int[(int)Math.pow(2, n) - 1][2];
        Hanoi(n, 1, 2, 3);
        return answer;
    }
    
    public void Hanoi(int n, int start, int mid, int end){
        if(n == 1){
            answer[idx][0] = start;
            answer[idx++][1] = end;
            return;
        }
        
        Hanoi(n-1, start, end, mid);
        answer[idx][0] = start;
        answer[idx++][1] = end;
        Hanoi(n-1, mid, start, end);
    }
}
