// https://www.acmicpc.net/problem/1292

import java.util.Scanner;
public class Main {
    public void solution(){
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();

        int sum = 0;
        int num = 1;
        int count = 0;
        for(int i = 0; i < B; i++){
            if(count < num){
                count++;
            }else{
                num++;
                count = 1;
            }

            if(i >= A-1){
                sum += num;
            }
        }

        System.out.println(sum);
    }
    public static void main(String[] args) {
        new Main().solution();
    }
}
