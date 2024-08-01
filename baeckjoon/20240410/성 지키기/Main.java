// https://www.acmicpc.net/problem/1236

import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        String[] arr = new String[N];

        for(int i = 0; i < N; i++){
                arr[i] = sc.next();
        }

        boolean[] row = new boolean[N];
        boolean[] col = new boolean[M];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(arr[i].charAt(j) == 'X'){
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        int remainRow = 0;
        for(int i = 0; i < N; i++){
            if(!row[i])
                remainRow++;
        }

        int remainCol = 0;
        for(int i = 0; i < M; i++){
            if(!col[i])
                remainCol++;
        }

        System.out.println(Math.max(remainRow, remainCol));
    }
}
