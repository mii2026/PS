import java.util.*;
import java.lang.*;
import java.io.*;


class Main {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        List<Node>[] graph = new ArrayList[n + 1];
        List<Node>[] reverseGraph = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(end, cost));
            reverseGraph[end].add(new Node(start, cost));
        }

        int[] dist1 = dijkstra(graph, x, n);
        int[] dist2 = dijkstra(reverseGraph, x, n);

        int max = 0;
        for(int i = 1; i <= n; i++) {
            max = Math.max(max, dist1[i] + dist2[i]);
        }

        System.out.print(max);
    }

    public int[] dijkstra(List<Node>[] graph, int start, int n) {
        int[] dist = new int[n+1];
        for(int i = 1; i <= n; i++) {
            dist[i] = 1000000000;
        }
        dist[start] = 0;

        boolean[] visited = new boolean[n+1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            
            if(visited[cur.idx]) continue;
            visited[cur.idx] = true;
            
            for(Node next: graph[cur.idx]) {
                if(cur.cost + next.cost < dist[next.idx]) {
                    dist[next.idx] = cur.cost + next.cost;
                    pq.add(new Node(next.idx, dist[next.idx]));
                }
            }
        }

        return dist;
    }

    class Node implements Comparable<Node> {
        int idx, cost;

        Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node d) {
            return this.cost - d.cost;
        }
    }
    
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}