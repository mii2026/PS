// https://school.programmers.co.kr/learn/courses/30/lessons/178870

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {1000000, 2000000};
        int start = 0;
        int end = 0;
        int sum = 0;
        
        while(end < sequence.length){
            sum += sequence[end];
            
            while (sum > k){
                sum -= sequence[start++];
            }
            
            if(sum == k){
                if(end - start < answer[1] - answer[0]){
                    answer[0] = start;
                    answer[1] = end;
                }
            }
            
            end++;
        }
        
        return answer;
    }
}
