import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    int n, m;
    String[] titles;
    int[] powers;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        titles = new String[n];
        powers = new int[n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            titles[i] = st.nextToken();
            powers[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++) {
            int score = Integer.parseInt(br.readLine());
            sb.append(getTitle(score)).append("\n");
        }

        System.out.print(sb);
    }

    public String getTitle(int score) {
        int start = 0;
        int end = n - 1;
        int answer = 1000000000;

        while(start <= end) {
            int mid = (start + end) / 2;

            if(powers[mid] < score) {
                start = mid + 1;
            } else {
                end = mid - 1;
                answer = Math.min(answer, mid);
            }
        }

        return titles[answer];
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}