import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.util.PriorityQueue;

class Main {

    private final int inf = 1000000;

    public class Node{
        int num, red, blue;
        int[] group;

        public Node(int num, int red, int blue, int[] group){
            this.num = num;
            this.red = red;
            this.blue = blue;
            this.group = group;
        }
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int answer = 0;
        int n = Integer.parseInt(br.readLine());
        int[] colors = new int[n];
        boolean[][][] visited = new boolean[n][450][450];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i < n; i++){
            colors[i] = Integer.parseInt(st.nextToken());    
        }

        int[] group = new int[n+1];
        group[1] = n;

        PriorityQueue<Node> q = new PriorityQueue<>((i, j) 
            -> (i.red == j. red ? j.blue - i.blue : i.red - j.red));
        q.add(new Node(1, 0, 0, group));

        while(!q.isEmpty()){
            Node cur = q.poll();
            int num = cur.num;
            
            if(num == n){
                System.out.print(cur.red);
                break;
            }

            if(visited[num][cur.red][cur.blue])
                continue;

            visited[num][cur.red][cur.blue] = true;

            for(int u = 1; u <= num; u++){
                for(int v = u; v <= Math.min(num, n - u); v++){
                    if(u == v && cur.group[u] < 2)
                        continue;
                    
                    if(cur.group[u] < 1 || cur.group[v] < 1)
                        continue;

                    int[] ngroup = new int[n+1];
                    for(int i = 0; i < n; i++){
                        ngroup[i] = cur.group[i];
                    }

                    ngroup[u]--;
                    ngroup[v]--;
                    ngroup[u+v]++;

                    int nblue = cur.blue;
                    int nred = cur.red;

                    if(colors[num] == 1) 
                        nblue += u * v;
                    else
                        nred += u * v;

                    q.add(new Node(num+1, nred, nblue, ngroup));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

}
