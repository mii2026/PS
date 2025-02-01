import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for(int test = 0; test < t; test++) {
            char[] arr = br.readLine().toCharArray();
            int k = Integer.parseInt(br.readLine());

            if(k == 1) {
                sb.append("1 1\n");
                continue;
            }
            
            int[] alpha = new int[26];
            int min = 1000000;
            int max = 0;

            for(char c: arr) {
                alpha[c - 'a']++;
            }

            for(int i = 0; i < arr.length; i++) {
                if(alpha[arr[i] - 'a']-- < k)
                    continue;
                
                int count = 1;
                for(int j = i + 1; j < arr.length; j++) {
                    if(arr[j] == arr[i])
                        count++;

                    if(count == k) {
                        min = Math.min(min, j - i + 1);
                        max = Math.max(max, j - i + 1);
                        break;
                    }
                }
            }

            if(max > 0) {
                sb.append(min).append(" ").append(max).append("\n");
            } else {
                sb.append("-1\n");
            }
        }

        System.out.print(sb);
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}