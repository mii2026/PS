import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) {
            int rank = 1;
            
            for(int j = 0; j < n; j++) {
                if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1])
                    rank++;
            }

            sb.append(rank).append(" ");
        }

        System.out.print(sb);
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}