// https://www.acmicpc.net/problem/14003

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;

public class Main {
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int top = 0;
        int[] arr = new int[n];
        int[] dp = new int[n];
        int[] save = new int[n];
        
        arr[0] = Integer.parseInt(st.nextToken());
        save[0] = arr[0];
        dp[0] = 0;

        for(int i = 1; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            
            if(save[top] < arr[i]){
                save[++top] = arr[i];
                dp[i] = top;
            } else if(save[top] == arr[i]){
                dp[i] = top;
            } else{
                int left = 0, right = top;
                while(left < right){
                    int mid = (left + right) / 2;
                    
                    if(save[mid] < arr[i]) left = mid + 1;
                    else right = mid;
                }

                save[right] = arr[i];
                dp[i] = right;
            }
        }

        Stack<Integer> stack = new Stack<>();
        int idx = top;
        for(int i = n-1; i >= 0; i--){
            if(dp[i] == idx){
                stack.push(arr[i]);
                idx--;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(top+1).append("\n");
        while(!stack.isEmpty()){
            sb.append(stack.pop()).append(" ");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
