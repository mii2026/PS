import java.util.*;
import java.lang.*;
import java.io.*;


class Main {

    String target;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        target = br.readLine();
        String str = br.readLine();

        System.out.print(dfs(str) ? 1 : 0);
    }

    public boolean dfs(String str) {
        if(str.length() == target.length()){
            return str.equals(target);
        }

        if(str.charAt(str.length() -1) == 'A' && dfs(str.substring(0, str.length() - 1))) {
            return true;
        }

        if(str.charAt(0) == 'B') {
            StringBuilder sb = new StringBuilder(str);
            if(dfs(sb.reverse().substring(0, str.length() - 1))) {
                return true;
            }
        }

        return false;
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}