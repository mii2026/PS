import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());
        int[] arr = new int[101];

        for(int i = 1; i <= 100; i++) {
            arr[i] = i;
        }

        for(int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[start] = end;
        }

        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[101];
        q.add(1);
        visited[1] = 1;

        while(!q.isEmpty()) {
            int cur = q.poll();

            for(int i = 1; i <= 6; i++) {
                int next = arr[cur + i];

                if(next == 100) {
                    System.out.print(visited[cur]);
                    return;
                }

                if(visited[next] > 0)
                    continue;

                visited[next] = visited[cur] + 1;
                q.add(next);
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}