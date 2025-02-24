import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Set<String> keywords = new HashSet<>();

        for(int i = 0; i < n; i++) {
            keywords.add(br.readLine());
        }

        for(int i = 0; i < m; i++) {
            String[] used = br.readLine().split(",");
            for(String str: used) {
                keywords.remove(str);
            }
            sb.append(keywords.size()).append("\n");
        }

        System.out.print(sb);
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}