// https://school.programmers.co.kr/learn/courses/30/lessons/135807

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];
        
        for(int i = 1; i < arrayA.length; i++)
            gcdA = gcd(gcdA, arrayA[i]);
        
        for(int i = 1; i < arrayB.length; i++)
            gcdB = gcd(gcdB, arrayB[i]);
        
        if(isDivisible(arrayA, gcdB))
            answer = gcdB;
        
        if(answer < gcdA && isDivisible(arrayB, gcdA))
            answer = gcdA;
            
        return answer;
    }
    
    public boolean isDivisible(int[] arr, int n){
        for(int i: arr){
            if(i % n == 0)
                return false;
        }
        return true;
    }
    
    public int gcd(int a, int b){
        if(a % b == 0) return b;
        return gcd(b, a%b);
    }
}
