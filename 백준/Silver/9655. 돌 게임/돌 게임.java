import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public void solution(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[1001];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 1;

        for(int i = 4; i <= n; i++) {
            if(dp[i-1] == 1 || dp[i-3] == 1)
                dp[i] = 2;
            else
                dp[i] = 1;
        }

        if(dp[n] == 1)
            System.out.print("SK");
        else
            System.out.print("CY");
    }
    
    public static void main(String[] args){
        new Main().solution();
    }
}