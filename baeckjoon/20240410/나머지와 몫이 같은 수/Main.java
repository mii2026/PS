// https://www.acmicpc.net/problem/1834

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();

        System.out.println((long)(N+1)*N*(N-1)/2);
    }
}
