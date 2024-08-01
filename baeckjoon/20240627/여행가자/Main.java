// https://www.acmicpc.net/problem/1976

import java.util.*;
import java.io.*;

class Main {
    ArrayList<Integer>[] map;
    int[] visited;
    
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        
        map = new ArrayList[n+1];
        visited = new int[n+1];
        for(int i = 1; i <= n; i++){
            map[i] = new ArrayList<Integer>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++){
                if(Integer.parseInt(st.nextToken()) == 1)
                    map[i].add(j);
            }
        }

        int group = 1;
        for(int i = 1; i <= n; i++){
            if(visited[i] == 0)
                bfs(i, group++);
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        group = visited[Integer.parseInt(st.nextToken())];
        for(int i = 1; i < m; i++){
            if(visited[Integer.parseInt(st.nextToken())] != group){
                System.out.print("NO");
                return;
            }
        }
        System.out.print("YES");
    }

    void bfs(int s, int group){
        Queue<Integer> q = new LinkedList<>();
        visited[s] = group;
        q.add(s);
        
        while(!q.isEmpty()){
            int cur = q.poll();

            for(int i: map[cur]){
                if(visited[i] != 0)
                    continue;

                visited[i] = group;
                q.add(i);
            }
        }
    }
    
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
