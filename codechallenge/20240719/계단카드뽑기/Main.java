import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    int n;
    int[] arr;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 1;
        int end = n;
        int answer = 0;

        while(start <= end){
            int mid = (start + end) / 2;

            if(check(mid)){
                answer = mid;
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        System.out.print(answer);
    }

    public boolean check(int num){
        int[] pockets = new int[50001];
        for(int j = 0; j < num; j++){
            pockets[arr[j]]++;
        }

        int prev = 0;
        boolean able = true;
        for(int j = 0; j < num; j++){
            prev += pockets[j];
            
            if(prev > j){
                able = false;
                break;
            }       
        }

        if(able)
            return true;

        for(int i = 1; i <= n - num; i++){
            pockets[arr[i-1]]--;
            pockets[arr[i+num-1]]++;
            
            prev = 0;
            able = true;
            for(int j = 0; j < num; j++){
                prev += pockets[j];
                
                if(prev > j){
                    able = false;
                    break;
                }       
            }

            if(able)
                return true;
        }

        return false;
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}