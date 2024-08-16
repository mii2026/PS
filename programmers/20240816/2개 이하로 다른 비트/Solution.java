// https://school.programmers.co.kr/learn/courses/30/lessons/77885

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] % 2 == 0)
                answer[i] = numbers[i] + 1;
            else 
                answer[i] = numbers[i] + minAdd(numbers[i]);
        }
        
        return answer;
    }
    
    public long minAdd(long num){
        int n = 0;
        while(num % 2 != 0){
            num /= 2;
            n++;
        }
        
        n--;
        
        return (long) Math.pow(2, n);
    }
}
