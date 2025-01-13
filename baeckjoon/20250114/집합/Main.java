import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.valueOf(br.readLine());
        boolean[] set = new boolean[21];
        StringBuilder answer = new StringBuilder();

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if(command.equals("add")) {
                int m = Integer.valueOf(st.nextToken());
                set[m] = true;
            } 
            else if(command.equals("remove")) {
                int m = Integer.valueOf(st.nextToken());
                set[m] = false;
            } 
            else if(command.equals("check")) {
                int m = Integer.valueOf(st.nextToken());
                answer.append(set[m] ? "1\n" : "0\n");
            } 
            else if(command.equals("toggle")) {
                int m = Integer.valueOf(st.nextToken());
                set[m] = !set[m];
            } 
            else if(command.equals("all")) {
                for(int j = 1; j <= 20; j++) {
                    set[j] = true;
                }
            } else if(command.equals("empty")) {
                for(int j = 1; j <= 20; j++) {
                    set[j] = false;
                }
            }
        }

        System.out.print(answer);
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
