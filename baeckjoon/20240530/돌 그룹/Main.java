// https://www.acmicpc.net/problem/12886

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.util.Queue;
import java.util.LinkedList;

public class Main {

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        if(a == b && b == c){
            System.out.print(1);
        }
        else if((a+b+c) % 3 != 0){
            System.out.print(0);
        }
        else{
            boolean[][] visited = new boolean[a+b+c][a+b+c];
            Queue<int[]> q = new LinkedList<>();

            q.add(new int[]{a, b, c});
            visited[a][b] = true;

            while(!q.isEmpty()){
                int[] cur = q.poll();

                if(cur[0] == cur[1] && cur[1] == cur[2]){
                    System.out.print(1);
                    return;
                }

                for(int i = 0; i <= 1; i++){
                    for(int j = i+1; j <= 2; j++){
                        if(cur[i] == cur[j])
                            continue;

                        int[] next = new int[]{cur[0], cur[1], cur[2]};
                        
                        if(cur[i] < cur[j]){
                            next[j] -= next[i];
                            next[i] *= 2;
                        }
                        else if(cur[i] > cur[j]){
                            next[i] -= next[j];
                            next[j] *= 2;
                        }

                        if(visited[next[i]][next[j]])
                            continue;

                        q.add(next);
                        visited[next[i]][next[j]] = true;
                    }
                }
            }

            System.out.print(0);
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
