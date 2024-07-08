// https://www.acmicpc.net/problem/1774

// 아이디어: 나온 친구들로 먼저 parents를 설정한다, 최소 스패닝 트리를 진행한다!

import java.util.*;
import java.io.*;

class Main {

    private int[] parents;
    
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parents = new int[n+1];
        for(int i = 1; i <= n; i++){
            parents[i] = i;
        }

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
        }
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
