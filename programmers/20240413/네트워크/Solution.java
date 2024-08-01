// https://school.programmers.co.kr/learn/courses/30/lessons/43162

class Solution {
    boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        
        int answer = 0;
        for(int i = 0; i < n; i++){
            if(!visited[i]){
            	dfs(computers, i);
                answer++;
            }
        }
        return answer;
    }
    
    void dfs(int[][] computers, int cur){
        visited[cur] = true;
        for(int i = 0; i < computers.length; i++){
            if(!visited[i] && computers[cur][i] == 1){
                dfs(computers, i);
            }
        }
    }
}