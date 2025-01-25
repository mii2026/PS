import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    int[] heart = new int[2];
    char[][] arr;
    int n;
    int lenWaist;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        
        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];

        for(int i = 0; i < n; i++) {
            char[] line = br.readLine().toCharArray();

            for(int j = 0; j < n; j++) {
                arr[i][j] = line[j];
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(arr[i][j] == '*'){
                    heart[0] = i + 1;
                    heart[1] = j;
                    answer.append(i+2).append(" ").append(j+1).append("\n");
                    break;
                }
            }
            if(heart[0] != 0)
                break;
        }

        answer.append(lenLeftArm()).append(" ");
        answer.append(lenRightArm()).append(" ");
        lenWaist = lenWaist();
        answer.append(lenWaist).append(" ");
        answer.append(lenLeftLeg()).append(" ");
        answer.append(lenRightLeg()).append(" ");

        System.out.print(answer);
    }

    public int lenLeftArm() {
        int num = 0;
        for(int i = heart[1] - 1; i >= 0; i--){
            if(arr[heart[0]][i] == '_')
                break;
            num++;
        }
        return num;
    }

    public int lenRightArm() {
        int num = 0;
        for(int i = heart[1] + 1; i < n; i++){
            if(arr[heart[0]][i] == '_')
                break;
            num++;
        }
        return num;
    }

    public int lenWaist() {
        int num = 0;
        for(int i = heart[0] + 1; i < n; i++){
            if(arr[i][heart[1]] == '_')
                break;
            num++;
        }
        return num;
    }

    public int lenLeftLeg() {
        int num = 0;
        for(int i = heart[0] + 1 + lenWaist; i < n; i++){
            if(arr[i][heart[1] - 1] == '_')
                break;
            num++;
        }
        return num;
    }

    public int lenRightLeg() {
        int num = 0;
        for(int i = heart[0] + 1 + lenWaist; i < n; i++){
            if(arr[i][heart[1] + 1] == '_')
                break;
            num++;
        }
        return num;
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}