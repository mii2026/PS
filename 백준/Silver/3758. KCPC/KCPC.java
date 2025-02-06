import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int test = 0; test < T; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] scores = new int[n+1][k+1];
            int[] submit = new int[n+1];
            int[] time = new int[n+1];

            for(int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());

                int team = Integer.parseInt(st.nextToken());
                int game = Integer.parseInt(st.nextToken());
                int score = Integer.parseInt(st.nextToken());

                scores[team][game] = Math.max(scores[team][game], score);
                submit[team]++;
                time[team] = i;
            }

            int[] teamScore = new int[n+1];
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= k; j++) {
                    teamScore[i] += scores[i][j];
                }
            }

            int rank = 1;
            for(int i = 1; i <= n; i++) {
                if(i == t) continue;

                if(teamScore[i] > teamScore[t]) {
                    rank++;
                } else if(teamScore[i] == teamScore[t] && submit[i] < submit[t]) {
                    rank++;   
                } else if(teamScore[i] == teamScore[t] && submit[i] == submit[t] && time[i] < time[t]) {
                    rank++;
                }
            }

            sb.append(rank).append("\n");
        }

        System.out.print(sb);
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}