import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        if(m == 0){
            System.out.print(n);
            return;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int prev = Integer.parseInt(st.nextToken());
        int max = prev;
        
        for(int i = 1; i < m; i++) {
            int pos = Integer.parseInt(st.nextToken());
            int diff = (int) Math.ceil((double) (pos - prev) / 2);
            prev = pos;

            if(diff > max) {
                max = diff;
            }
        }

        if(n - prev > max){
            max = n - prev;
        }

        System.out.print(max);
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}