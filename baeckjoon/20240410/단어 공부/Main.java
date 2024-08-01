// https://www.acmicpc.net/problem/1157

import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc =new Scanner(System.in);
        
        int[] arr = new int[26];

        String str = sc.nextLine();
        for(char c: str.toCharArray()){
            if(c>='a'){
                arr[c-'a']++;
            }
            else{
                arr[c-'A']++;
            }
        }

        int max = -1;
        char answer = '?';
        for(int i = 0; i < 26; i++){
            if(arr[i] > max){
                max = arr[i];
                answer = (char)(65 + i);
            }
            else if(arr[i] == max){
                answer = '?';
            }
        }
        System.out.println(answer);
    }
}
