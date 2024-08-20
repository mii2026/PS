// https://school.programmers.co.kr/learn/courses/30/lessons/131704

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        int[] stack = new int[order.length];
        int top = 0;
        int num = 0;
        
        for(int i = 1; i <= order.length; i++){
            if(order[num] == i){
                num++;
                answer++;
                continue;
            }
            
            while(top > 0 && stack[top-1] == order[num]){
                answer++;
                num++;
                top--;
            }
            
            stack[top++] = i;
        }
        
        while(top > 0 && stack[top-1] == order[num]){
            answer++;
            num++;
            top--;
        }
        
        return answer;
    }
}
