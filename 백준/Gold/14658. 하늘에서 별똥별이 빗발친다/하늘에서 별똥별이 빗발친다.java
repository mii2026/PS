import java.util.*;
import java.lang.*;
import java.io.*;


class Main {

    int[][] stars;
    int n, m, l, k;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        stars = new int[k][2];

        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            stars[i][0] = Integer.parseInt(st.nextToken());
            stars[i][1] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for(int[] s1: stars) {
            for(int[] s2: stars) {
                max = Math.max(max, avaliableStar(s1[0], s2[1]));
            }
        }

        System.out.print(k - max);
    }

    public int avaliableStar(int x, int y) {
        int num = 0;
        for(int[] s: stars) {
            if(s[0] <= x + l && s[0] >= x && s[1] <= y + l && s[1] >= y)
                num++;
        }
        return num;
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}