import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String password = br.readLine();

        while(!password.equals("end")) {
            boolean check = false;
            int consonants = 0;
            int vowels = 0;

            if(isVowels(password.charAt(0))) {
                vowels++;
                check = true;
            } else { 
                consonants++;
            }
            char prev = password.charAt(0);

            for(int j = 1; j < password.length(); j++) {
                char cur = password.charAt(j);

                if(isVowels(cur)) {
                    vowels++;
                    consonants = 0;
                    check = true;
                } else { 
                    consonants++;
                    vowels = 0;
                }

                if((cur == prev && cur != 'e' && cur != 'o') || vowels >= 3 || consonants >= 3){
                    check = false;
                    break;
                }

                prev = cur;
            }

            sb.append("<").append(password).append(">")
                .append((check ? " is acceptable.\n" : " is not acceptable.\n")); 

            password = br.readLine();
        }

        System.out.print(sb);
    }

    public boolean isVowels (char c) {
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
            return true;
        return false;
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}