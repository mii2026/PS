import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        if(a + b - 1 > n) {
            System.out.print(-1);
            return;
        }

        StringBuilder sb = new StringBuilder();

        if(a == 1) {
            sb.append(b).append(" ");

            for(int i = 0; i < n - b; i++) {
                sb.append("1 ");
            }

            for(int i = b - 1; i > 0; i--) {
                sb.append(i).append(" ");
            }
        } else {
            for(int i = 0; i < n - b - a + 1; i++) {
                sb.append("1 ");
            }

            for(int i = 1; i < a; i++) {
                sb.append(i).append(" ");
            }

            sb.append(Math.max(a, b)).append(" ");

            for(int i = b - 1; i > 0; i--) {
                sb.append(i).append(" ");
            }
        }

        System.out.print(sb);
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}