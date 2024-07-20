import java.util.*;
import java.io.*;

class Main {

    ArrayList<Integer>[] graph;
    boolean[] visited;
    int[] sub;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int q  = Integer.parseInt(st.nextToken());
        graph  = new ArrayList[n+1];

        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < n-1; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        visited = new boolean[n+1];
        sub = new int[n+1];
        dfs(r);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < q; i++){
            int u = Integer.parseInt(br.readLine());
            sb.append(sub[u]).append("\n");
        }
        System.out.print(sb);
    }

    public int dfs(int cur){
        visited[cur] = true;
        sub[cur] = 1;

        for(int c: graph[cur]){
            if(visited[c]) continue;
            sub[cur] += dfs(c);
        }      

        return sub[cur];
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}