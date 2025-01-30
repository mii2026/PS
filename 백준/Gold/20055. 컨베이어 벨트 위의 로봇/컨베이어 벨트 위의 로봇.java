import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] belt = new int[n * 2];
        boolean[] robot = new boolean[n * 2];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n * 2; i++) {
            belt[i] = Integer.parseInt(st.nextToken());        
        }

        int start = 0;
        int step = 0;
        
        while(k > 0) {
            int temp = belt[n * 2 - 1];
            for(int i = n * 2 - 1; i > 0 ; i--) {
                belt[i] = belt[i - 1];
            }
            belt[0] = temp;
            
            for(int i = n - 1; i > 0; i--) {
                robot[i] = robot[i - 1];
            }
            robot[n - 1] = false;
            robot[0] = false;

            for(int i = n - 1; i > 0; i--) {
                if(robot[i - 1] && !robot[i] && belt[i] > 0) {
                    robot[i - 1] = false;
                    robot[i] = true;
                    belt[i]--;
                    if(belt[i] == 0) 
                        k--;
                }
            }

            if(belt[0] > 0) {
                robot[0] = true;
                belt[0]--;
                if(belt[0] == 0)
                    k--;
            }
            
            step++;
        }

        System.out.print(step);
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}