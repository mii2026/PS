import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.util.ArrayList;

class Main {
    ArrayList<Integer>[] edges;
    boolean[] visited;
    int[][] score;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        edges = new ArrayList[n+1];
        for(int i = 1; i <= n; i++){
            edges[i] = new ArrayList<>();
        }

        for(int i = 0; i < n-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            edges[u].add(v);
            edges[v].add(u);
        }

        visited = new boolean[n+1];
        score = new int[n+1][2];

        visited[1] = true;
        dfs(1);

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++){
            sb.append(score[i][0] >= score[i][1] ? 1 : 0).append("\n");
        }
        System.out.print(sb);
    }

    public void dfs(int cur){
        int min = 1000000;
        int idx = 0;

        for(int n: edges[cur]){

            if(!visited[n]){
                visited[n] = true;
                dfs(n);
                
                if(min > score[n][0] - score[n][1]){
                    min  = score[n][0] - score[n][1];
                    idx = n;
                }
            }
        }
        
        if(idx == 0){
            score[cur][0] = cur;
        } else {
            score[cur][0] = score[idx][1] + cur;
            score[cur][1] = score[idx][0];
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
