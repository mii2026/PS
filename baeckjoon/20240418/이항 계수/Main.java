// https://www.acmicpc.net/problem/11401

import java.util.Scanner;

public class Main {
    final int div = 1_000_000_007;

    public void solution() throws Exception{
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        long a = 1;
        for(int i = N-K+1; i <= N; i++){
            a = (a * i) % div;
        }

        long b = 1;
        for(int i = 1; i <= K; i++){
            b = (b * i) % div;
        }

        System.out.print((a * pow(b, div-2)) % div);
    }

    public long pow(long x, int n){
        if(n == 0)
            return 1;

        long temp = pow(x, n/2) % div;
        
        if(n % 2 == 1)
            return (((temp*temp) % div) * x) % div;
        return (temp*temp) % div;
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
