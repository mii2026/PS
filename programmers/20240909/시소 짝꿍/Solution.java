// https://school.programmers.co.kr/learn/courses/30/lessons/152996

class Solution {
    public long solution(int[] weights) {
        int[] arr = new int[1001];
        for(int w: weights){
            arr[w]++;
        }
        
        long answer = 0;
        for(int i = 100; i <= 1000; i++){
            int n1 = arr[i];
            answer += ((long)n1*(n1 - 1)/2);
            
            if(i % 2 == 0){
                int n2 = arr[i/2];
                answer += ((long)n1 * n2);
            }
            
            if(i % 3 == 0){
                int n2 = arr[i * 2 / 3];
                answer += ((long)n1 * n2);
            }
            
            if(i % 4 == 0){
                int n2 = arr[i * 3 / 4];
                answer += ((long)n1 * n2);
            }
        }
        return answer;
    }
}
