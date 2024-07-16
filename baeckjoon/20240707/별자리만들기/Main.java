import java.util.*;
import java.io.*;

class Main {
    int[] parents;

    public class Edge{
        int start;
        int end;
        double dist;

        Edge(int start, int end, double dist){
            this.start = start;
            this.end = end;
            this.dist = dist;
        }
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        double[][] stars = new double[n][2];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            stars[i][0] = Double.parseDouble(st.nextToken());
            stars[i][1] = Double.parseDouble(st.nextToken());
        }

        Edge[] edges = new Edge[n*(n-1)/2];
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                double dist = Math.sqrt(Math.pow(stars[i][0] - stars[j][0], 2) + Math.pow(stars[i][1] - stars[j][1], 2));
                edges[count++] = new Edge(i, j, dist);
            }
        }
        Arrays.sort(edges, (i, j) -> Double.compare(i.dist, j.dist));
        
        parents = new int[n];
        for(int i = 0; i < n; i++){
            parents[i] = i;
        }

        count = 1;
        double answer = 0;
        for(int i = 0; i < n*(n-1)/2; i++){
            int a = edges[i].start;
            int b = edges[i].end;

            if(getParents(a) != getParents(b)){
                union(a, b);
                answer += edges[i].dist;
                count++;
            }

            if(count == n)
                break;
        }

        System.out.printf("%.2f", answer);
    }

    public int getParents(int n){
        if(n == parents[n])
            return n;
        return parents[n] = getParents(parents[n]);
    }

    public void union(int a, int b){
        int pa = getParents(a);
        int pb = getParents(b);

        if(pa != pb)
            parents[pb] = pa;
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
