// https://school.programmers.co.kr/learn/courses/30/lessons/250135

class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {        
        int answer = calAlert(h2, m2, s2) - calAlert(h1, m1, s1);
        if((h1 == 0 || h1 == 12) && m1 == 0 && s1 == 0)
            answer++;
        
        return answer;
    }
    
    int calAlert(int h, int m, int s){
        int nalert = h * 119 + m * 2 - 1;
        
        double hdgree = (h*30 + m*0.5 + (s*0.5)/60) % 360;
        double mdgree = m*6 + s*0.1;
        double sdgree = s * 6;
        
        if(hdgree <= sdgree)
            nalert++;
        if(mdgree <= sdgree)
            nalert++;
        if(h >= 12)
            nalert -= 2;
        
        return nalert;
    }
}
​

