import java.util.*;
import java.lang.*;
import java.io.*;


class Main {

    int n;
    int[] costs;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        costs = new int[n];
        int high = 0;
        int low = 1;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            costs[i] = Integer.parseInt(st.nextToken());
            high = Math.max(high, costs[i]);
        }

        int available = Integer.parseInt(br.readLine());
        while(high >= low) {
            int mid = (high + low) / 2;

            if(sum(mid) > available) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.print(high);
        
    }

    public int sum(int max) {
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += Math.min(max, costs[i]);
        }
        return sum;
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}