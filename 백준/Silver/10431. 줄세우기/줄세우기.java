import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for(int test = 0; test < n; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[20];
            int count = 0;
            
            sb.append(st.nextToken()).append(" ");

            for(int i = 0; i < 20; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                for(int j = i; j > 0; j--) {
                    if(arr[j] < arr[j-1]){
                        int temp = arr[j];
                        arr[j] = arr[j-1];
                        arr[j-1] = temp;
                        count++;
                    }
                }
            }

            sb.append(count).append("\n");    
        
        }

        System.out.print(sb);
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}