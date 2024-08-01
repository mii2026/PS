// https://school.programmers.co.kr/learn/courses/30/lessons/250137

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int curHP = health;
        int ptime = 0;
        
        for(int i = 0; i < attacks.length; i++){
            int duration = attacks[i][0] - ptime - 2;
                
            curHP = curHP + duration * bandage[1] + duration / bandage[0] * bandage[2];
            curHP = Math.min(health, curHP);
            curHP -= attacks[i][1];
            
            if(curHP <= 0){
                return -1;
            }
            
            ptime = attacks[i][0];
        }
        
        return curHP;
    }
}