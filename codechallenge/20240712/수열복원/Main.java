import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

class Main {

    int[] arr;
    int visited[];

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int m = (int)Math.pow(2, n);
        arr = new int[n];
        visited = new int[n*100000+1]; 

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            visited[Integer.parseInt(st.nextToken())]++;
        }

        int idx = 1;

        for(int i = 0; i < n - 1; i++){
            while(visited[idx] == 0){
                idx++;
            }

            arr[i] = idx;
            visited[idx]--;
            dfs(i, 0, idx);
            System.out.print(idx + " ");
        }

        while(visited[idx] == 0){
            idx++;
        }
        System.out.print(idx);
    }

    public void dfs(int idx, int cur, int sum){
        for(int i = cur; i < idx; i++){
            int nsum = sum + arr[i];
            visited[nsum]--;
            dfs(idx, i+1, nsum);
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
