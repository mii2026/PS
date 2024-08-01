// https://www.acmicpc.net/problem/7682

import java.util.*;
import java.io.*;

class Main {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        while(true){
            String str = br.readLine();

            if(str.equals("end")) 
                break;

            char[] board = str.toCharArray();
            
            if(checkEnd(board)) sb.append("valid\n");
            else sb.append("invalid\n");
        }

        System.out.print(sb);
    }

    public boolean checkEnd(char[] board){
        int xnum = 0;
        int onum = 0;
        for(char c: board){
            if(c == 'X') xnum++;
            else if(c == 'O') onum++;
        }

        if(xnum > onum + 1 || onum > xnum) return false;

        boolean xwin = false;
        boolean owin = false;
        for(int i = 0; i < 3; i++){
            if(board[i] == 'X' && board[i] == board[i+3] && board[i] == board[i+6])
                xwin = true;
            if(board[3*i] == 'X' && board[3*i] == board[3*i+1] && board[3*i] == board[3*i+2])
                xwin = true;

            if(board[i] == 'O' && board[i] == board[i+3] && board[i] == board[i+6])
                owin = true;
            if(board[3*i] == 'O' && board[3*i] == board[3*i+1] && board[3*i] == board[3*i+2])
                owin = true;
        }
        
        if(board[0] == 'X' && board[0] == board[4] && board[0] == board[8])
            xwin = true;
        if(board[2] == 'X' && board[2] == board[4] && board[2] == board[6])
            xwin = true;

        if(board[0] == 'O' && board[0] == board[4] && board[0] == board[8])
            owin = true;
        if(board[2] == 'O' && board[2] == board[4] && board[2] == board[6])
            owin = true;

        if(xnum == 5 && onum == 4){
            return !owin;
        } else if(xnum == onum){
            return (owin && !xwin);
        } else if(xnum == onum + 1){
            return (xwin && !owin);
        }
        
        return true;
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
