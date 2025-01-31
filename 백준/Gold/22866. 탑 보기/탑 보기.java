import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] buildings = new int[n + 1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            buildings[i] = Integer.parseInt(st.nextToken());
        }

        int[] nums = new int[n + 1];
        int[] near = new int[n + 1];
        
        Stack<Integer> s = new Stack<>();
        for(int i = 1; i <= n; i++) {
            while(!s.empty() && buildings[s.peek()] <= buildings[i]) {
                s.pop();
            }

            if(!s.empty()) {
                nums[i] += s.size();
                near[i] = s.peek();
            }
            
            s.push(i);
        }

        s = new Stack<>();
        for(int i = n; i > 0; i--) {
            while(!s.empty() && buildings[s.peek()] <= buildings[i]) {
                s.pop();
            }

            if(!s.empty()) {
                nums[i] += s.size();
                if(near[i] == 0 || (i - near[i] > s.peek() - i))
                    near[i] = s.peek();
            }
            
            s.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            if(nums[i] == 0) {
                sb.append("0\n");
            } else {
                sb.append(nums[i]).append(" ").append(near[i]).append("\n");
            }
        }

        System.out.print(sb);
        
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}