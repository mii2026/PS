// https://school.programmers.co.kr/learn/courses/30/lessons/147354

import java.util.Arrays;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        
        int answer = 0;
        
        Arrays.sort(data, (i, j) 
                    -> i[col - 1] == j[col - 1] ? j[0] - i[0] : i[col - 1] - j[col - 1]);
        
        int[] sarray = new int[row_end - row_begin + 1];
        for(int i = row_begin; i <= row_end; i++){
            int s = 0;
            for(int j = 0; j < data[0].length; j++){
                s += (data[i - 1][j] % i);
            }
            
            answer ^= s;
        }
        
        return answer;
    }
}
