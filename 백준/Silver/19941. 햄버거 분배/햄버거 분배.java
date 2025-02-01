import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        char[] map = br.readLine().toCharArray();

        int answer = 0;
        int idx = 0;
        for(int i = 0; i < n; i++) {
            if(map[i] == 'H')
                continue;

            idx = Math.max(idx, i - k);
            
            while(idx < n && idx <= i + k) {
                if(map[idx++] == 'H') {
                    answer++;
                    break;
                }
            }
        }

        System.out.print(answer);
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}