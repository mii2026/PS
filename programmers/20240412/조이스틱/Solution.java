// https://school.programmers.co.kr/learn/courses/30/lessons/42860

class Solution {
    public int solution(String name) {
        char[] arr = name.toCharArray();
        int answer = arr.length - 1;
        
        int alen = 0;
        int llen = arr.length - 1;
        int rlen = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 'A'){
                alen++;
                rlen = arr.length - 1 - i;
                llen = Math.max(0, i-alen);
                answer = Math.min(answer, llen+rlen+Math.min(llen,rlen));
            }
            else{
                alen = 0;
            }
        }
        
        for(char c: arr){
            answer += Math.min(c-'A', 26-c+'A');
        }
        return answer;
    }
}