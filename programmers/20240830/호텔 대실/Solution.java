// https://school.programmers.co.kr/learn/courses/30/lessons/155651
// 누적합

class Solution {
    public final int MAX_TIME = 1450;
    public final int CLEAN_TIME = 10;
    
    public int solution(String[][] book_time) {
        int[] rooms = new int[MAX_TIME];
         
        for(int i = 0; i < book_time.length; i++){
            int startTime = changeToMin(book_time[i][0]);
            int endTime = changeToMin(book_time[i][1]) + CLEAN_TIME;
            
            rooms[startTime]++;
            rooms[endTime]--;
        }
        
        int cur = 0;
        int answer = 0;
        for(int i = 0; i < MAX_TIME; i++){
            cur += rooms[i];
            rooms[i] = cur;
            answer = Math.max(answer, cur);
        }    
        return answer;
    }
    
    public int changeToMin(String time){
        int hour = Integer.parseInt(time.split(":")[0]);
        int min = Integer.parseInt(time.split(":")[1]);
        return hour*60 + min;
    }
}
