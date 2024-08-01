// https://blog.naver.com/mii2026/223411022034

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());
        int[] seq = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}

        for(int i = 0; i < N; i++){
            while(stack.size() > 0 && seq[i] > seq[stack.peek()]){
                seq[stack.pop()] = seq[i];
            }
            stack.push(i);
        }

        while(stack.size() > 0){
            seq[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
		for (int n : seq) {
			sb.append(n).append(' ');
		}
 
		System.out.println(sb);
    }
}
