// https://www.acmicpc.net/problem/2839

import java.util.Scanner;

public class Main {
    public void solution(){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int min = -1;
        for(int i = N/5; i >= 0; i--){
            int remain = N - i*5;
            if(remain % 3 == 0){
                min = i + remain/3;
                break;
            }
        }

        System.out.println(min);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
