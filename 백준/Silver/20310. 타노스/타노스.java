import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int zeros = 0;
        int ones = 0;
        
        for(char c: str.toCharArray()) {
            if(c == '0') {
                zeros++;
            } else if(c == '1') {
                ones++;
            }
        }

        zeros /= 2;
        ones /= 2;

        StringBuilder sb = new StringBuilder();
        for(char c: str.toCharArray()) {
            if(c == '0') {
                if(zeros > 0) {
                    sb.append("0");
                    zeros--;
                }
            } else if(c == '1') {
                if(ones > 0) {
                    ones--;
                } else {
                    sb.append("1");
                }
            }
        }

        System.out.print(sb);
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}