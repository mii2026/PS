// https://www.acmicpc.net/problem/1987

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int R = sc.nextInt();
        int C = sc.nextInt();
        char[][] arr = new char[R][C];

        for(int i = 0; i < R; i++){
            String str = sc.next();
            for(int j = 0; j < C; j++){
                arr[i][j] = str.charAt(j);
            }
        }

        boolean[][] visited = new boolean[R][C];
        boolean[] alpha = new boolean[26];
        
        visited[0][0] = true;
        alpha[arr[0][0]-'A'] = true;
        
        System.out.println(dfs(arr, visited, alpha, 0, 0, 1));
    }

    public static int dfs(
        char[][] arr, boolean[][] visited, boolean[] alpha,
        int x, int y, int depth
    ){

        int max = 0;

        visited[x][y] = true;
        alpha[arr[x][y] - 'A'] = true;

        if(x > 0 && !visited[x-1][y] && !alpha[arr[x-1][y]-'A']){
            max = Math.max(max, dfs(arr, visited, alpha, x-1, y, depth+1));
        }

        if(x < visited.length-1 && !visited[x+1][y] && !alpha[arr[x+1][y]-'A']){
            max = Math.max(max, dfs(arr, visited, alpha, x+1, y, depth+1));
        }

        if(y > 0 && !visited[x][y-1] && !alpha[arr[x][y-1]-'A']){
            max = Math.max(max, dfs(arr, visited, alpha, x, y-1, depth+1));
        }

        if(y < visited[0].length-1 && !visited[x][y+1] && !alpha[arr[x][y+1]-'A']){
            max = Math.max(max, dfs(arr, visited, alpha, x, y+1, depth+1));
        }

        visited[x][y] = false;
        alpha[arr[x][y] - 'A'] = false;

        if(max == 0)
            return depth;
        return max;
    }
}
