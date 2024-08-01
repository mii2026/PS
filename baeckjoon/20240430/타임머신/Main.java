// https://www.acmicpc.net/problem/11657 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    class Edge{
        int vertex, weight;

        Edge(int vertex, int weight){
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Edge>[] graph = new ArrayList[n];

        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<Edge>();
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());

            int n1 = Integer.parseInt(st.nextToken()) - 1;
            int n2 = Integer.parseInt(st.nextToken()) - 1;
            int weight = Integer.parseInt(st.nextToken());

            graph[n1].add(new Edge(n2, weight));
        }   
        
        long[] dist = new long[n];
        long inf = Long.MAX_VALUE;
        for(int i = 1; i < n; i++){
            dist[i] = inf; 
        }

        for(int i = 1; i <= n; i++){
            for(int v = 0; v < n; v++){
                if(dist[v] == inf){
                    continue; 
                }

                for(Edge e: graph[v]){
                    if(dist[e.vertex] > dist[v] + e.weight){
                        dist[e.vertex] = dist[v] + e.weight;
                        if(i == n){
                            System.out.print("-1");
                            return;
                        }
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < n; i++){
            if(dist[i] == inf){
                sb.append("-1\n");
            }else{
                sb.append(dist[i]).append("\n");
            }
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
​