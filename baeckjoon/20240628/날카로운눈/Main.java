import java.util.*;
import java.io.*;

class Main {
    long[][] seqs;
    
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        seqs = new long[n][3];
        
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            seqs[i][0] = Long.parseLong(st.nextToken());
            seqs[i][1] = Long.parseLong(st.nextToken());
            seqs[i][2] = Long.parseLong(st.nextToken());
        }

        long start = 1;
        long end = 2147483647;
        long mid = 0;
        long result = -1;
        
        while(start <= end){
            mid = (start + end) / 2;

            if(checkOdd(mid)){
                end = mid - 1;
                result = mid;
            } else{
                start = mid + 1;
            }            
        }

        if(result == -1){
            System.out.print("NOTHING");
        } else{
            System.out.print(result + " " + cnt(result));
        }
    }

    public boolean checkOdd(long num){ 
        long result = 0;
        for(long[] seq: seqs){
            if(seq[0] > num)
                continue;

            result += (((Math.min(seq[1], num) - seq[0]) / seq[2]) + 1);
        }
        return result % 2 != 0;
    }

    public long cnt(long num){
        long result = 0;
        for(long[] seq: seqs){
            if(num < seq[0] || num > seq[1]) continue;

            if((num - seq[0]) % seq[2] == 0) result++;
        }
        return result;
    }
    
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
