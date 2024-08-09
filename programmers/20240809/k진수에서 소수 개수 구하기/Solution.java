// https://school.programmers.co.kr/learn/courses/30/lessons/92335

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        long num = 0;
        long d = 1;
        
        while(n > 0) {
            if(n % k == 0){
                if(isPrime(num))
                    answer++;
                num = 0;
                d = 1;
            } else {
                num += ((n % k) * d);
                d *= 10;
            }
            n /= k;
        }
        
        if(isPrime(num))
            answer++;
        
        return answer;
    }
    
    public boolean isPrime(long n){
        if(n <= 1)
            return false;
        
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0)
                return false;
        }
        return true;
    }
}
