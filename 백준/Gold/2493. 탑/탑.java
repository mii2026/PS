import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] buildings = new int[n];
        int[] recipients = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int height = Integer.parseInt(st.nextToken());
            buildings[i] = height;

            while(!stack.isEmpty() && buildings[stack.peek()] < height) {
                stack.pop();
            }

            if(!stack.isEmpty()) {
                recipients[i] = stack.peek() + 1;
            }

            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append(recipients[i]).append(" ");
        }
        System.out.print(sb);
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}