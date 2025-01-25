import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    boolean[] arr;
    int n;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new boolean[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            arr[i] = st.nextToken().equals("1");
        }

        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            if(Integer.parseInt(st.nextToken()) == 1) {
                men(Integer.parseInt(st.nextToken()));
            } else {
                women(Integer.parseInt(st.nextToken()));
            }
            
        }

        StringBuilder answer = new StringBuilder();
        for(int i = 1; i <= n; i++){
            answer.append(arr[i] ? 1 : 0).append(" ");
            if(i % 20 == 0)
                answer.append("\n");
        }

        System.out.print(answer);
    }

    public void men(int num) {
        for(int i = num; i <= n; i += num) {
            arr[i] = !arr[i];
        }
    }

    public void women(int num) {
        arr[num] = !arr[num];
        
        for(int i = 1; i < Math.min(num, n - num + 1); i++) {
            if(arr[num - i] != arr[num + i])
                break;
            
            arr[num - i] = !arr[num - i];
            arr[num + i] = !arr[num + i];
        }
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}