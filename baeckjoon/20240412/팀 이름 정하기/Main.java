// https://www.acmicpc.net/problem/1296

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        char[] target = new char[]{'L', 'O', 'V', 'E'};
        int maxScore = 0;
        String answer = "a";

        String name = br.readLine();
        int[] cnt = new int[4];
        for(char c: name.toCharArray()){
            for(int i = 0; i < 4; i++){
                if(target[i] == c){
                    cnt[i]++;
                    break;
                }
            }
        }

        int N = Integer.valueOf(br.readLine());

        for(int i = 0; i < N; i++){
            int[] tmp = new int[]{cnt[0], cnt[1], cnt[2], cnt[3]};
            String str = br.readLine();
            
            for(char c: str.toCharArray()){
                for(int j = 0; j < 4; j++){
                    if(target[j] == c){
                        tmp[j]++;
                        break;
                    }
                }
            }

            int score = ((tmp[0] + tmp[1]) * (tmp[0] + tmp[2]) * (tmp[0] + tmp[3])
                        * (tmp[1] + tmp[2]) * (tmp[1] + tmp[3]) * (tmp[2] + tmp[3])) % 100;
            
            if(score > maxScore){
                maxScore = score;
                answer = str;
            }
            else if(score == maxScore && answer.compareTo(str) > 0){
                maxScore = score;
                answer = str;
            }
        }
        
        System.out.println(answer);

        br.close();
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
