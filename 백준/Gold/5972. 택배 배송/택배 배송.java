import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    int N, M;
    List<List<Node>> graph = new ArrayList<>();

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            graph.get(v1).add(new Node(v2, e));
            graph.get(v2).add(new Node(v1, e));
        }

        System.out.print(dijkstra(1, N));
    }

    public int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[N+1];
        Arrays.fill(dist, 1000000000);

        pq.add(new Node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            if(cur.cost > dist[cur.index]) {
                continue;
            }

            for(Node next: graph.get(cur.index)) {
                int newCost = cur.cost + next.cost;

                if(newCost < dist[next.index]) {
                    dist[next.index] = newCost;
                    pq.offer(new Node(next.index, newCost));
                }
            }
        }

        return dist[end];
    }

    class Node implements Comparable<Node> {
        int index, cost;
        
        Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.cost, other.cost);
        }
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}