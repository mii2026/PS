import java.util.*;
import java.io.*;

class Main {

    private int[] parents;

    public class Edge{
        int s1, s2;
        double dist;

        public Edge(int s1, int s2, double dist){
            this.s1 = s1;
            this.s2 = s2;
            this.dist = dist;
        }
    }
    
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = 0;
        double answer = 0;
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] stars = new int[n][2];
        Edge[] edges = new Edge[n*(n-1)/2];
        parents = new int[n+1];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            stars[i][0] = Integer.parseInt(st.nextToken());
            stars[i][1] = Integer.parseInt(st.nextToken());
            
            parents[i] = i;
        }
        
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                double dist = Math.sqrt(Math.pow(stars[i][0] - stars[j][0], 2) + Math.pow(stars[i][1] - stars[j][1], 2));
                edges[count++] = new Edge(i, j, dist);
            }   
        }
        Arrays.sort(edges, (i, j) -> Double.compare(i.dist, j.dist));

        count = 1;
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int s1 = Integer.parseInt(st.nextToken()) - 1;
            int s2 = Integer.parseInt(st.nextToken()) - 1;

            if(getParent(s1) != getParent(s2)){
                count++;
                union(s1, s2);
            }
        }

        for(int i = 0; i < n*(n-1)/2; i++){
            int s1 = edges[i].s1;
            int s2 = edges[i].s2;

            if(getParent(s1) != getParent(s2)){
                count++;
                answer += edges[i].dist;
                union(s1, s2);
            }

            if(count == n)
                break;
        }

        System.out.printf("%.2f", answer);
    }

    public int getParent(int n){
        if(parents[n] == n)
            return n;
        return parents[n] = getParent(parents[n]);
    }

    public void union(int a, int b){
        int pa = getParent(a);
        int pb = getParent(b);

        if(pa != pb)
            parents[pb] = pa;
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
