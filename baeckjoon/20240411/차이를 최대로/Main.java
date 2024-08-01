// https://www.acmicpc.net/problem/10819  

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    int N;
    int[] arr;
    boolean[] visited;

    int max = 0;

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.valueOf(br.readLine());
        arr = new int[N];
        visited = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.valueOf(st.nextToken());
        }

        dfs(new int[N], 0);

        System.out.println(max);
    }

    public void dfs(int[] seq, int depth){
        if(depth == N){
            int num = 0;
            for(int i = 0; i < N-1; i++){
                num = num + Math.abs(seq[i]-seq[i+1]);
            }
            max = Math.max(num, max);
        }

        for(int i = 0; i < N; i++){
            if(!visited[i]){
                visited[i] = true;
                seq[depth] = arr[i];
                dfs(seq, depth+1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
