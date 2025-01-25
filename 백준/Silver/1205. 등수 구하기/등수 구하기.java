import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        if(n == 0) {
            System.out.print(1);
            return;
        }
        
        int rank = 1;
        int same = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            
            if(score < num) {
                rank++;
            } else if(score == num) {
                same++;
            }
        }

        System.out.print((rank + same > p) ? -1 : rank);
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}