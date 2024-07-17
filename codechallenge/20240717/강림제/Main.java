import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

class Main {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        // 각 시간에 신도 수 구하기
        int[] num = new int[n+1];
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            for(int j = s; j < e; j++){
                num[j]++;
            }
        }

        // 신도수가 모자란 구간 구하기
        ArrayList<int[]> inter = new ArrayList<>();
        boolean alice = true;
        int answer = 0, start = 0;

        for(int i = 1; i <= n; i++){
            if(num[i] >= t){
                answer++;
                if(alice == false){
                    alice = true;
                    inter.add(new int[]{start, i});
                }
            } else if(num[i] < t && alice){
                alice = false;
                start = i;
            }
        }
        
        if(num[n] < t)
            inter.add(new int[]{start, n+1});

        // 친구 없어도 전부 강림하면 n출력 후 반환
        if(answer == n){
            System.out.print(n);
            return;
        }

        // 신도수가 모자란 구간 친구수 별 엘리스 강림 횟수
        int[][] add = new int[inter.size()][k+1];
        for(int i = 0; i < inter.size(); i++){
            for(int j = 0; j <= k; j++){
                for(int time = inter.get(i)[0]; time < inter.get(i)[1]; time++){
                    if(num[time] + j >= t){
                        add[i][j]++;
                    }
                }
            }
        }

        // 신도수가 모자란 구간에서만 dp
        int[][] dp = new int[inter.size()][k+1];
        for(int i = 1; i <= k; i++){
            dp[0][i] = add[0][i];
        }

        for(int i = 1; i < inter.size(); i++){
            for(int j = 1; j <= k; j++){
                for(int prev = 0; prev <= j; prev++){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][prev] + add[i][j-prev]);
                }
            }
        }

        System.out.print(answer+dp[inter.size()-1][k]); 
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}