import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= n; i++) {
            q.add(i);
        }

        while(q.size() > 1) {
            q.remove();
            q.add(q.remove());
        }

        System.out.print(q.peek());
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}