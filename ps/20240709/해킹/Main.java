import java.util.*;
import java.io.*;

class Main {

    private final int inf = 1000000000;

    public class Node{
        private int computer, time;

        Node(int computer, int time){
            this.computer = computer;
            this.time = time;
        }

        int getComputer(){
            return this.computer;
        }

        int getTime(){
            return this.time;
        }
    }
    
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int t = Integer.parseInt(br.readLine());

        for(int test = 0; test < t; test++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            ArrayList<Node>[] graph = new ArrayList[n+1];
            int[] distance = new int[n+1];
            boolean[] visited = new boolean[n+1];

            for(int i = 1; i <= n; i++){
                graph[i] = new ArrayList<Node>();
                distance[i] = inf;
            }
            distance[c] = 0;

            for(int i = 0; i < d; i++){
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                graph[b].add(new Node(a, s));
            }

            PriorityQueue<Node> q = new PriorityQueue<>((i, j) -> i.getTime() - j.getTime());
            q.add(new Node(c, 0));

            int ncom = 0;
            int maxTime = 0;

            while(!q.isEmpty()){
                Node cur = q.poll();

                if(visited[cur.getComputer()])
                    continue;

                visited[cur.getComputer()] = true;
                ncom++;
                maxTime = Math.max(maxTime, cur.getTime());

                for(Node next: graph[cur.getComputer()]){
                    if(visited[next.getComputer()])
                        continue;

                    q.add(new Node(next.getComputer(), cur.getTime() + next.getTime()));
                }
            }

            sb.append(ncom).append(" ").append(maxTime).append("\n");
        }

        System.out.print(sb);
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
