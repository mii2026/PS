// https://www.acmicpc.net/problem/10775

import java.util.*;
import java.io.*;

class Main {
    int[] parents;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int g = Integer.parseInt(br.readLine());
        int p = Integer.parseInt(br.readLine());
       
        parents = new int[g+1];
        for(int i = 0; i <= g; i++){
            parents[i] = i;
        }

        int[] planes = new int[p];
        for(int i = 0; i < p; i++){
            planes[i] = Integer.parseInt(br.readLine());
        }

        int answer = 0;
        for(int plane: planes){
            int maxGate = getParent(plane);
            if(maxGate == 0)
                break;

            answer++;
            parents[maxGate] = maxGate - 1;
        }

        System.out.print(answer);
    }

    public int getParent(int n){
        if(parents[n] == n) 
            return n;
        return parents[n] = getParent(parents[n]);
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}