// https://www.acmicpc.net/problem/2529

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    long max = 0;
    long min = Long.MAX_VALUE;
    boolean[] visited;
    char[] arr;
    int k;

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        k = Integer.valueOf(br.readLine());
        visited = new boolean[10];
        arr = new char[k];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < k; i++){
            arr[i] = st.nextToken().charAt(0);
        }

        for(int i = 0; i < 10; i++){
            visited[i] = true;
            dfs(i, 1);
            visited[i] = false;
        }

        if(max/Math.pow(10, k) < 1)
            System.out.println("0"+max);
        else
            System.out.println(max);
        if(min/Math.pow(10, k) < 1)
            System.out.println("0"+min);
        else
            System.out.println(min);
        
        br.close();
    }

    public void dfs(long number, int depth){
        if(depth > k){
            max = Math.max(max, number);
            min = Math.min(min, number);
            return;
        }

        int preNum = (int)(number%10);

        for(int i = 0; i < 10; i++){
            if(!visited[i] && ((arr[depth-1] == '>' && preNum > i) || (arr[depth-1] == '<' && preNum < i))){
                visited[i] = true;
                dfs(number*10 + i, depth+1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
        
    }
}
