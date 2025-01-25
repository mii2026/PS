import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        Set<String> set = new HashSet<>();
        int need = 1;
        
        String game = st.nextToken();
        if (game.equals("F")) {
            need = 2;
        } else if (game.equals("O")) {
            need = 3;
        }

        for(int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        System.out.print(set.size() / need);
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}