import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int sum = 0;
        int max = 0;
        int count = 0;
        Queue<Integer> q = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int hit = Integer.parseInt(st.nextToken());
            q.add(hit);
            sum += hit;

            if(q.size() < k) continue;

            if(sum > max) {
                max = sum;
                count = 1;
            } else if(sum == max) {
                count++;
            }

            sum -= q.poll();
        }

        System.out.print(max == 0 ? "SAD" : max + "\n" + count);
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}