import java.util.*;
import java.io.*;

class Main {
    int[] parents;
    
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parents = new int[n+1];

        for(int i = 1; i <= n; i++){
            parents[i] = i;
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            switch (command) {
                case 0:
                    union(a, b);
                    break;
                case 1:
                    sb.append(isSameGroup(a, b) ? "YES\n" : "NO\n");
                    break;
                default:
                    break;
            }
        }

        System.out.print(sb);
    }

    public void union(int a, int b){
        int p1 = getParents(a);
        int p2 = getParents(b);

        if(p1 != p2)
            parents[p2] = p1;
    }

    public int getParents(int cur){
        if(cur == parents[cur])
            return cur;
        return parents[cur] = getParents(parents[cur]);
    }

    public boolean isSameGroup(int a, int b){
        return getParents(a) == getParents(b);
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
