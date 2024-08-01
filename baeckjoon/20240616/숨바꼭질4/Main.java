// https://www.acmicpc.net/problem/13913  

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

public class Main {
    class Node{
        int pos, depth;

        public Node(int pos, int depth){
            this.pos = pos;
            this.depth = depth;
        }
    }

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Node> q = new LinkedList<>();
        boolean[] visited = new boolean[100001];
        int[] prev = new int[100001];
        for(int i = 0; i < 100001; i++){
            prev[i] = -1;
        }

        q.add(new Node(n, 0));
        visited[n] = true;

        while(!q.isEmpty()){
            Node cur = q.poll();
            
            if(cur.pos == k){
                sb.append(cur.depth).append("\n");
                break;
            }

            if(cur.pos+1 <= 100000 && !visited[cur.pos+1]){
                q.add(new Node(cur.pos+1, cur.depth+1));
                visited[cur.pos+1] = true;
                prev[cur.pos+1] = cur.pos;
            }

            if(cur.pos-1 >= 0 && !visited[cur.pos-1]){
                q.add(new Node(cur.pos-1, cur.depth+1));
                visited[cur.pos-1] = true;
                prev[cur.pos-1] = cur.pos;
            }

            if(cur.pos*2 <= 100000 && !visited[cur.pos*2]){
                q.add(new Node(cur.pos*2, cur.depth+1));
                visited[cur.pos*2] = true;
                prev[cur.pos*2] = cur.pos;
            }
        }

        Stack<Integer> s = new Stack<>();
        int cur = k;
        while(cur != -1){
            s.push(cur);
            cur = prev[cur];
        }

        while(!s.isEmpty()){
            sb.append(s.pop()).append(" ");
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
