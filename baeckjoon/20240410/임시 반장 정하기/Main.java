// https://www.acmicpc.net/problem/1268

import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int[][] arr = new int[N][N];
        
        for(int i=0; i < N; i++){
            for(int j = 0; j < 5; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        
        int[] same = new int[N];

        for(int i = 0; i < N-1; i++){
            for(int j = i; j < N; j++){
                for(int k = 0; k < 5; k++){
                    if(arr[i][k] == arr[j][k]){
                        same[i]++;
                        same[j]++;
                        break;
                    }
                }
            }
        }

        int answer = 1;
        int max = 0;

        for(int i = 0; i < N; i++){
            if(same[i] > max){
                max = same[i];
                answer = i+1;
            }
        }
        System.out.println(answer);
    }
}
