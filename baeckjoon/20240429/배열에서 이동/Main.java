// https://www.acmicpc.net/problem/1981

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.util.Queue;
import java.util.LinkedList;

public class Main {
    
    class Node{
        int x, y;

        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        final int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        int max = 0;
        int min = 200;

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, arr[i][j]);
                max = Math.max(max, arr[i][j]);
            }
        }

        int result = 200;
        int start = 0;
        int end = max - min;
        int mid;

        while(start <= end){
            mid = (start + end) / 2;

            boolean check = false;
            for(int i = min; i + mid <= max; i++){
                if(i <= arr[0][0] && arr[0][0] <= i + mid && bfs(arr, i, i + mid, n)){
                    check = true;
                    break;
                }
            }

            if(check){
                result = Math.min(result, mid);
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        System.out.print(result);
    }

    public boolean bfs(int[][] arr, int s, int e, int n){        
        boolean[][] visited = new boolean[n][n];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0));
        visited[0][0] = true;

        while(!q.isEmpty()){
            Node cur = q.poll();
            if(cur.x == n-1 && cur.y == n-1){
                q.clear();
                return true;
            }

            for(int i = 0; i < 4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny]){
                    continue;
                }
            
                visited[nx][ny] = true;

                if(arr[nx][ny] >= s && arr[nx][ny] <= e){
                    q.add(new Node(nx, ny));
                }
            }
        }

        return false;
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
