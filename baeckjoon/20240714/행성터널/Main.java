// https://www.acmicpc.net/problem/2887

import java.util.*;
import java.io.*;

class Main {
    int[] parents;

    public class Edge{
        int s1, s2;
        long dist;

        public Edge(int s1, int s2, long dist){
            this.s1 = s1;
            this.s2 = s2;
            this.dist = dist;
        }
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] stars = new int[n][4];
        Edge[] edges = new Edge[(n-1) * 3];
        parents = new int[n];
        
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            stars[i][0] = i;
            stars[i][1] = Integer.parseInt(st.nextToken());
            stars[i][2] = Integer.parseInt(st.nextToken());
            stars[i][3] = Integer.parseInt(st.nextToken());

            parents[i] = i;
        }

        int count = 0;
        for(int dir = 1; dir <= 3; dir++){
            int d = dir;
            Arrays.sort(stars, (i, j) -> i[d] - j[d]);
            for(int i = 0; i < n-1; i++){
                int s1 = stars[i][0];
                int s2 = stars[i+1][0];
                long dist = Math.min(Math.abs(stars[i][1] - stars[i+1][1]), 
                                     Math.min(Math.abs(stars[i][2] - stars[i+1][2]), Math.abs(stars[i][3] - stars[i+1][3])));

                edges[count++] = new Edge(s1, s2, dist);
            }
        }

        Arrays.sort(edges, (i, j) -> Long.compare(i.dist, j.dist));

        count = 1;
        long answer = 0;
        for(int i = 0; i < (n-1) * 3; i++){
            int s1 = edges[i].s1;
            int s2 = edges[i].s2;

            if(getParents(s1) != getParents(s2)){
                union(s1, s2);
                answer += edges[i].dist;
                count++;
            }

            if(count == n)
                break;
        }

        System.out.print(answer);
        
    }

    public int getParents(int n){
        if(n == parents[n])
            return n;
        return parents[n] = getParents(parents[n]);
    }

    public void union(int a, int b){
        int pa = getParents(a);
        int pb = getParents(b);

        if(pa != pb){
            parents[pb] = pa;
        }
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
