// https://school.programmers.co.kr/learn/courses/30/lessons/181188

import java.util.Arrays;
class Solution {
    public int solution(int[][] targets) {
        
        Arrays.sort(targets, (x, y) -> x[1]-y[1]);
        
        
        int answer = 0;
        int end = 0;
        for(int i = 0; i < targets.length; i++){
            if(end <= targets[i][0]){
                end = targets[i][1];
                answer++;
            }
        }
        return answer;
    }
}