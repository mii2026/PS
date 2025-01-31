import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = br.readLine();
        int num = 1;
        int idx = 0;

        while(idx < str.length()) {
            String temp = String.valueOf(num);

            for(int i = 0; i < temp.length(); i++) {
                if(temp.charAt(i) == str.charAt(idx)) {
                    idx++;
                    
                    if(idx >= str.length()) {
                        System.out.print(num);
                        return;
                    }
                }   
            }

            num++;
        }
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}