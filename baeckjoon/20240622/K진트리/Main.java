// https://www.acmicpc.net/problem/11812

import java.util.*;
import java.io.*;

class Main {
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        long n = Long.parseLong(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        for(int i = 0; i < q; i++){
            st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());

            if(k == 1){
                long diff = Math.abs(x - y);
                sb.append(diff).append("\n");
                continue;
            }

            long diff = 0;
            while(x != y){
                if(x > y)
                    x = (x - 2) / k + 1;
                else
                    y = (y - 2) / k + 1;
                diff++;
            }
            sb.append(diff).append("\n");
        }

        System.out.print(sb);
    }
    
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
