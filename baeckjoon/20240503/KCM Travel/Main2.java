import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main2 {
    int inf = 1000000000;

    class Node{
        int end, time, cost;
        
        Node(int end, int time, int cost){
            this.end = end;
            this.time = time;
            this.cost = cost;
        }
    }

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for(int test = 0; test < t; test++){
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            ArrayList<Node>[] graph = new ArrayList[n+1];

            for(int i = 1; i <= n; i++){
                graph[i] = new ArrayList<Node>();
            }

            for(int i = 0; i < k; i++){
                st = new StringTokenizer(br.readLine());
                
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                graph[u].add(new Node(v, d, c));
            }

            int[][] dp = new int[n+1][m+1];
            
            for(int i = 0; i <= n; i++){
                for(int j = 0; j <= m; j++){
                    dp[i][j] = inf;
                }
            }
            dp[1][0] = 0;

            for(int i = 0; i < m; i++){
                for(int j = 1; j < n; j++){
                    for(Node cur: graph[j]){
                        if(i + cur.cost <= m){
                            dp[cur.end][i+cur.cost] = Math.min(dp[cur.end][i+cur.cost], dp[j][i] + cur.time);
                        }
                    }
                }
            }

            
            int min = inf;
            for(int i = 0; i <= m; i++){
                min = Math.min(min, dp[n][i]);
            }
            System.out.println(min == inf ? "Poor KCM" : min);
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
​