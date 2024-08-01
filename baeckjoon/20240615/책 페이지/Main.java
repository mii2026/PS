// https://www.acmicpc.net/problem/1019

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] answer = new int[10];

        for(int i = 0; i < 10; i++){
            int mod = 10;
            int mod2 = 1;
            while(n/mod2 > 0){
                if(i == 0)
                    answer[i] += ((n/mod - 1) * mod2);
                else
                    answer[i] += ((n/mod) * mod2);
                
                if((n%mod)/mod2 > i)
                    answer[i] += mod2;
                else if((n%mod)/mod2 == i)
                    answer[i] += (n % mod2 + 1);
                
                mod *= 10;
                mod2 *= 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 10; i++){
            sb.append(answer[i]).append(" ");
        }

        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
​