// https://www.acmicpc.net/problem/5213 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.util.Queue;
import java.util.LinkedList;

public class Main {
    int[] dx1 = {-1, 0, -1, 1, -1, 0};    
    int[] dx2 = {0, 1, -1, 1, 0, 1};
    int[] dy = {-1, -1, 0, 0, 1, 1};
    int[][] arr;

    public class Node{
        int x, y, depth;
        
        public Node(int x, int y, int depth){
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int maxTile = n*n - n/2;
        arr = new int[maxTile][2];

        for(int i = 0; i < maxTile; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int result = 1;
        int max = 0;
        Queue<Node> q = new LinkedList<>();
        int[] prev = new int[maxTile];
        for(int i = 0; i < maxTile; i++)
            prev[i] = -1;
    
        q.add(new Node(0, 0, 1));
        prev[0] = 0;

        while(!q.isEmpty()){
            Node cur = q.poll();
            int idx = cur.y*n + cur.x - cur.y/2;

            if(idx == maxTile - 1){
                max = idx;
                result = cur.depth;
                break;
            }

            if(max < idx){
                max = idx;
                result = cur.depth;
            }

            for(int i = 0; i < 6; i++){
                int nx = cur.x + ((cur.y % 2 == 0) ? dx1[i] : dx2[i]);
                int ny = cur.y + dy[i];
                int nidx = ny*n + nx - ny/2;

                if(nx < 0 || nx >= (n - ny%2) || ny < 0 || ny >= n)
                    continue;

                if(prev[nidx] != -1)
                    continue;
                
                if(goCheck(i, idx, nidx)){
                    q.add(new Node(nx, ny, cur.depth+1));
                    prev[nidx] = idx;
                }
            }
        }

        System.out.println(result);

        int cur = max;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < result; i++){
            sb.insert(0, (cur+1)+" ");
            cur = prev[cur];
        }
        System.out.print(sb);
    }

    boolean goCheck(int i, int idx1, int idx2){
        if(i % 2 == 0){
            return arr[idx1][0] == arr[idx2][1];
        }else{
            return arr[idx1][1] == arr[idx2][0];
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
​