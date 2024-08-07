// https://school.programmers.co.kr/learn/courses/30/lessons/87390

class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right - left + 1)];
        
        int idx = 0;
        for(long i = left; i <= right; i++){
            int num = (int) Math.max(i / n, i % n) + 1;
            answer[idx++] = num;
        }
        
        return answer;
    }
}
