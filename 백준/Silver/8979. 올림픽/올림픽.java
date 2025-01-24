import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int idx = 0;
        int result = 1;
        int[][] arr = new int[n][4];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < 4; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }

            if(arr[i][0] == k)
                idx = i;
        }

        for(int i = 0; i < n; i++) {
            if(arr[i][1] > arr[idx][1]) {
                result++;
            } else if(arr[i][1] == arr[idx][1] && arr[i][2] > arr[idx][2]) {
                result++;
            } else if(arr[i][1] == arr[idx][1] && arr[i][2] == arr[idx][2] && arr[i][3] > arr[idx][3]) {
                result++;
            }
        }

        System.out.print(result);
        
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}