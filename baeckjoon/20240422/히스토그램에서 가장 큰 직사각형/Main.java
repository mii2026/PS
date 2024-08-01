// https://www.acmicpc.net/problem/6549

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public long findMax(int[] arr){
        long area = 0;
        int[] stack = new int[arr.length];
        int top = 0;
        
        for(int i = 0; i < arr.length; i++){
            while(top > 0 && arr[stack[top-1]] >= arr[i]){
                int h = arr[stack[--top]];
                int width = i - ((top == 0) ? 0 : stack[top-1] + 1);

                area = Math.max(area, (long)h * width);
            }

            stack[top++] = i;
        }

        while(top > 0){
            int h = arr[stack[--top]];
            int width = arr.length - ((top == 0) ? 0 : stack[top-1] + 1);

            area = Math.max(area, (long)h * width);
        }

        return area;
    }

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuffer sb = new StringBuffer();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        while(n != 0){
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            sb.append(findMax(arr)).append("\n");

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
