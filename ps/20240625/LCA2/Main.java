import java.util.*;
import java.io.*;

class Main {
    int h;
    int[] depth;
    int[][] dp;
    ArrayList<Integer>[] tree;
    
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        h = (int)Math.ceil(Math.log(n)/Math.log(2)) +1;
        depth = new int[n+1];
        dp = new int[n+1][h];
        tree = new ArrayList[n+1];

        for(int i = 1; i <= n; i++){
            tree[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < n-1; i++){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            
            tree[n1].add(n2);
            tree[n2].add(n1);
        }

        parents(1, 0, 1);
        for(int i = 1; i < h; i++){
            for(int j = 2; j <= n; j++){
                dp[j][i] = dp[dp[j][i-1]][i-1];
            }
        }

        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            sb.append(LCA(n1, n2)).append("\n");
        }
        System.out.print(sb);
    }

    public void parents(int cur, int parent, int d){
        depth[cur] = d;
        for(int i: tree[cur]){
            if(i == parent)
                continue;
            dp[i][0] = cur;
            parents(i, cur, d+1);
        }
    }

    public int LCA(int n1, int n2){
        if(depth[n1] < depth[n2]){
            int temp = n1;
            n1 = n2;
            n2 = temp;
        }

        int diff = depth[n1] - depth[n2];
        int i = 0;
        while(diff > 0){
            if(diff % 2 == 1)
                n1 = dp[n1][i];
            diff = diff >> 1;
            i++;
        }

        if(n1 == n2)
            return n1;

        for(i = h-1; i >= 0; i--){
            if(dp[n1][i] != dp[n2][i]){
                n1 = dp[n1][i];
                n2 = dp[n2][i];
            }
        }
        return dp[n1][0];
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
