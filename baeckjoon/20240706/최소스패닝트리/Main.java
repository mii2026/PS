import java.util.*;
import java.io.*;

class Main {

    int[] parents;
    
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        
        int[][] edges = new int[e][3];
        for(int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine());

            edges[i][0] = Integer.parseInt(st.nextToken());
            edges[i][1] = Integer.parseInt(st.nextToken());
            edges[i][2] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(edges, (i, j) -> i[2] - j[2]);

        parents = new int[v+1];
        for(int i = 1; i <= v; i++)
            parents[i] = i;

        int answer = 0;
        int ne = 0;
        for(int i = 0; i < e; i++){
            if(getParent(edges[i][0]) != getParent(edges[i][1])){
                union(edges[i][0], edges[i][1]);
                answer += edges[i][2];
                ne++;
            }

            
            if(ne == v-1)
                break;
        }

        System.out.print(answer);
    }

    public int getParent(int n){
        if(parents[n] == n)
            return n;
        return parents[n] = getParent(parents[n]);
    }

    public void union(int a, int b){
        int pa = getParent(a);
        int pb = getParent(b);

        if(pa != pb){
            parents[pb] = pa;
        }
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
