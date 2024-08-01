// https://school.programmers.co.kr/learn/courses/30/lessons/214288

import java.util.ArrayList;

class Solution {
    public int solution(int k, int n, int[][] reqs) {
        ArrayList[] timetables = timetable(k, reqs);
        
        int[][] waits = new int[k][n - k + 3];
        for(int i = 0; i < k; i++){
            waits[i][1] = waitTime(timetables[i], 1);
        }
        
        int answer = minWaitTime(timetables, waits, n-k, k);
        return answer;
    }
    
    public ArrayList[] timetable(int k, int[][] reqs){
        ArrayList[] result = new ArrayList[k];
        
        for(int i = 0; i < k; i++){
            result[i] = new ArrayList<int[]>();
        }
        
        for(int i = 0; i < reqs.length; i++){
            result[reqs[i][2]-1].add(new int[]{reqs[i][0], reqs[i][1]});
        }
        
        return result;
    }
    
    public int waitTime(ArrayList<int[]> timetable, int num){
        int result = 0;
        int[] endtimes = new int[num];
        
        for(int i = 0; i < timetable.size(); i++){
            int starttime = timetable.get(i)[0];
            int duration = timetable.get(i)[1];
            
            int min = 10000000;
            int idx = 0;
            
            for(int j = 0; j < num; j++){
                if(starttime >= endtimes[j]){
                    endtimes[j] = starttime + duration;
                    min = 0;
                    break;
                }
                if(min > endtimes[j] + duration){
                    min = endtimes[j] + duration;
                    idx = j;
                }
            }
            
            if(min != 0){
                result += (endtimes[idx] - starttime);
                endtimes[idx] = min;
            }
        }
        
        return result;
    }
    
    public int minWaitTime(ArrayList[] timetables, int[][] wait, int num, int k){
        int[] mentors = new int[k];
        for(int i = 0; i < k; i++){
            mentors[i] = 1;
        }
        
        if(num > 0){
            for(int i = 0; i < k; i++){
                wait[i][2] = waitTime(timetables[i], 2);
            }

            for(int i = 0; i < num; i++){
                int max = 0;
                int idx = 0;

                for(int j = 0; j < k; j++){
                    int diff = wait[j][mentors[j]] - wait[j][mentors[j]+1];
                    if(diff > max){
                        max = diff;
                        idx = j;
                    }
                }    

                mentors[idx]++;
                wait[idx][mentors[idx]+1] = waitTime(timetables[idx], mentors[idx]+1);
            }
        }
        
        int result = 0;
        for(int i = 0; i < k; i++){
            result += wait[i][mentors[i]];
        }
        return result;
    }
}
​

​

