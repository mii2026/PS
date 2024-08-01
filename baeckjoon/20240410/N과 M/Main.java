// https://www.acmicpc.net/problem/15649

import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        boolean[] visited = new boolean[N];

        dfs(visited, N, M, 0, "");
    }

    public static void dfs(
        boolean[] visited, int N, int M, int depth, String seq
    ){
        if(depth == M){
            System.out.println(seq);
            return;
        }

        for(int i = 0; i < N; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(visited, N, M, depth+1, seq+(i+1)+" ");
                visited[i] = false;
            }
        }

    }
}
