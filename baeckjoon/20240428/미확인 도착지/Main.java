// https://www.acmicpc.net/problem/9370

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.Collections;

public class Main {
    class Node{
        int end, weight;

        Node(int end, int weight){
            this.end = end;
            this.weight = weight;
        }
    }

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        final int T = Integer.parseInt(br.readLine());

        for(int test = 0; test < T; test++){
            st = new StringTokenizer(br.readLine());
            final int n = Integer.parseInt(st.nextToken());
            final int m = Integer.parseInt(st.nextToken());
            final int t = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            final int s = Integer.parseInt(st.nextToken());
            final int g = Integer.parseInt(st.nextToken());
            final int h = Integer.parseInt(st.nextToken());

            ArrayList<Node>[] arr = new ArrayList[n+1];
            for(int i = 0; i < n+1; i++){
                arr[i] = new ArrayList<Node>();
            }
            for(int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());
                int n1 = Integer.parseInt(st.nextToken());
                int n2 = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                
                arr[n1].add(new Node(n2, cost));
                arr[n2].add(new Node(n1, cost));
            }

            int[] s_dis = dijkstra(n, s, arr);
            int[] g_dis = dijkstra(n, g, arr);
            int[] h_dis = dijkstra(n, h, arr);

            ArrayList<Integer> candidates = new ArrayList<>();
            for(int i = 0; i < t; i++){
                int c = Integer.parseInt(br.readLine());
                
                if(s_dis[c] == s_dis[g] + g_dis[h] + h_dis[c] 
                || s_dis[c] == s_dis[h] + h_dis[g] + g_dis[c]){
                    candidates.add(c);
                }
            }
            Collections.sort(candidates);

            for(int i: candidates){
                sb.append(i).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    public int[] dijkstra(int n, int s, ArrayList<Node>[] arr){
        int[] dis = new int[n+1];
        boolean[] visited = new boolean[n+1];
        PriorityQueue<Node> heap = new PriorityQueue<>((i, j) -> i.weight - j.weight);
        
        for(int i = 1; i < n+1; i++){
            if(i != s){
                dis[i] = Integer.MAX_VALUE;
            }
        }
        heap.add(new Node(s, 0));

        while(!heap.isEmpty()){
            Node cur = heap.poll();
            
            if(visited[cur.end])
                continue;

            visited[cur.end] = true;

            for(Node next: arr[cur.end]){
                if(!visited[next.end] && dis[next.end] > dis[cur.end] + next.weight){
                    dis[next.end] = dis[cur.end] + next.weight;
                    heap.add(new Node(next.end, dis[next.end]));
                }
            }
        }

        return dis;
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
