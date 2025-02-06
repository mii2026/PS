import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    String target;
    int[] targets = new int[26];

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        target = br.readLine();
        int count = 0;

        for(char c: target.toCharArray()) {
            targets[c - 'A']++;
        }

        for(int i = 0; i < n - 1; i++) {
            if(check(br.readLine())) {
                count++;
            }
        }

        System.out.print(count);
    }

    public boolean check(String str) {
        int[] alphabet = new int[26];
        for(char c: str.toCharArray()) {
            alphabet[c - 'A']++;
        }

        int total = 0;
        for(int i = 0; i < 26; i++) {
            int diff = Math.abs(targets[i] - alphabet[i]);
            if(diff > 1) return false;

            total += diff;
        }

        return total < 2 || (str.length() == target.length() && total == 2);
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}