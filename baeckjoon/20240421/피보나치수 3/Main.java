// https://www.acmicpc.net/problem/2749

import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        n = n % 1500000;
        
        int prev1 = 0;
        int prev2 = 1;
        int next = 1;

        for(int i = 1; i < n; i++){
            next = (prev1 + prev2) % 1000000;
            prev1 = prev2;
            prev2 = next;
        }

        System.out.print(next);
    }
}
