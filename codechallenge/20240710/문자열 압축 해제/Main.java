import java.util.Scanner;
import java.util.Stack;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] S = sc.nextLine().toCharArray();

        Stack<Character> s = new Stack<>();
        int answer = 0;

        for(char c: S){
            if(c != ')'){
                s.push(c);
                continue;
            }

            int Q = answer;
            while(s.pop() != '('){
                Q++;
            }
            int K = s.pop() - '0';

            answer = K * Q;            
        }

        while(!s.isEmpty()){
            s.pop();
            answer++;
        }

        System.out.print(answer);
    }
}
