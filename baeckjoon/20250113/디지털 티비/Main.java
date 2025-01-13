// https://www.acmicpc.net/problem/2816

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.valueOf(br.readLine());
        String[] arr = new String[n];
        StringBuilder answer = new StringBuilder();

        for(int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        for(int i = 0; i < n; i++) {
            if(arr[i].equals("KBS1")) {
                for(int j = i; j > 0; j--) {
                    String temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;

                    answer.append(4);
                }
                
                break;
            }
            
            answer.append(1);
        }

        for(int i = 0; i < n; i++) {
            if(arr[i].equals("KBS2")) {
                for(int j = i; j > 1; j--) {
                    answer.append(4);
                }
                
                break;
            }
            
            answer.append(1);
        }

        System.out.print(answer);
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
