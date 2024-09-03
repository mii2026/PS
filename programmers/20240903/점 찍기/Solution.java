// https://school.programmers.co.kr/learn/courses/30/lessons/140107

class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        long n = d / k;
        for(long i = 0 ; i <= d / k; i++){
            for(long j = n; j >= 0; j--){
                if(Math.sqrt(Math.pow(i*k, 2) + Math.pow(j*k, 2)) <= d){
                    n = j + 1;
                    answer += n;
                    break;
                }
            } 
        }
        return answer;
    }
}
