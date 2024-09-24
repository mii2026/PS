// https://school.programmers.co.kr/learn/courses/30/lessons/142085

import java.util.PriorityQueue;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((i, j) -> j - i);
        
        for(int i = 0; i < enemy.length; i++) {
            n -= enemy[i];
            maxHeap.add(enemy[i]);
            
            while(n < 0 && k > 0) {
                n += maxHeap.poll();
                k--;
            }
            
            if(n < 0)
                return i;
        }
        
        return enemy.length;
    }
}
