// https://www.acmicpc.net/problem/10830 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        int[][] arr = new int[N][N];
        
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int[][] answer = pow(arr, B);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                sb.append(answer[i][j]%1000).append(" ");
            }
            sb.append("\n");
        }
    
        System.out.print(sb);
    }

    public int[][] pow(int[][] arr, long B){
        if(B == 1){
            return arr;
        }
        
        int[][] temp = pow(arr, B/2);
        if(B % 2 == 1){
            return mult(mult(temp, temp), arr);
        }
        else{
            return mult(temp, temp);
        }
    }

    public int[][] mult(int[][] arr1, int[][] arr2){
        int N = arr1.length;

        int[][] result = new int[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                for(int k = 0; k < N; k++){
                    result[i][j] += arr1[i][k] * arr2[k][j];
                }
                result[i][j] %= 1000;
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
