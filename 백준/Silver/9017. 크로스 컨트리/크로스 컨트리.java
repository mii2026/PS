import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int t = Integer.valueOf(br.readLine());

        for(int test = 0; test < t; test++) {
            int n = Integer.valueOf(br.readLine());
            
            int[] ranks = new int[n];
            Map<Integer, Integer> members = new HashMap<>();
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                int team = Integer.valueOf(st.nextToken());
                ranks[i] = team;
                members.put(team, members.getOrDefault(team, 0) + 1);
            }

            int score = 0;
            Map<Integer, Integer> teamScore = new HashMap<>();
            Map<Integer, Integer> teamCount = new HashMap<>();
            Map<Integer, Integer> fifthRank = new HashMap<>();
            
            for(int i = 0; i < n; i++) {
                int team = ranks[i];
                if(members.get(team) < 6){
                    continue;
                }

                teamCount.put(team, teamCount.getOrDefault(team, 0) + 1);
                score++;
                
                if(teamCount.get(team) < 5){
                    teamScore.put(team, teamScore.getOrDefault(team, 0) + score);
                } else if(teamCount.get(team) == 5) {
                    fifthRank.put(team, score);
                }
            }

            int win = 0;
            int winPoint = 10000;
            for(int team: teamScore.keySet()) {
                int curScore = teamScore.get(team);
                if(win == 0 ||
                   winPoint > curScore || 
                   (winPoint == curScore && fifthRank.get(win) > fifthRank.get(team))) {
                    winPoint = curScore;
                    win = team;
                }
            }

            answer.append(win).append("\n");
        }

        System.out.print(answer);
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}