import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] distances = new int[n-1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n - 1; i++) {
            distances[i] = Integer.valueOf(st.nextToken());
        }

        int minCost = 1000000000;
        int answer = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n - 1; i++) {
            int cost = Integer.valueOf(st.nextToken());

            if(cost < minCost) {
                minCost = cost;
            }

            answer += minCost * distances[i];
        }

        System.out.print(answer);
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}