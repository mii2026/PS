// https://school.programmers.co.kr/learn/courses/30/lessons/62048

class Solution {
    public long solution(int w, int h) {
        long gcd = gcd(Math.max(w, h), Math.min(w, h));
        return (long)w * h - (w + h - gcd);
    }
    
    public long gcd(int a, int b){
        if(a % b == 0) return b;
        return gcd(b, a%b);
    }
}
