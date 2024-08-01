// https://www.acmicpc.net/problem/3108 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    class Rect{
        int x1, x2, y1, y2;

        Rect(int x1, int x2, int y1, int y2){
            this.x1 = x1;
            this.x2 = x2;
            this.y1 = y1;
            this.y2 = y2;
        }

        boolean intersect(int x1, int x2, int y1, int y2){
            if(x1 < this.x1 && x2 > this.x2 && y1 < this.y1 && y2 > this.y2)
                return false;
            if(this.x1 < x1 && this.x2 > x2 && this.y1 < y1 && this.y2 > y2)
                return false;
            if(x1 > this.x2 || x2 < this.x1 || y1 > this.y2 || y2 < this.y1)
                return false;
            return true;
        }
    }

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;
        int n = Integer.parseInt(br.readLine());
        Rect[] rects = new Rect[n];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            rects[i] = new Rect(x1, x2, y1, y2);

            if((x1 * x2 == 0 && y1 * y2 <= 0) || (y1 * y2 == 0 && x1 * x2 <= 0))
                answer = -1;
        }

        boolean[][] intersect = new boolean[n][n];

        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                if(rects[i].intersect(rects[j].x1, rects[j].x2, rects[j].y1, rects[j].y2)){
                    intersect[i][j] = true;
                    intersect[j][i] = true;
                }
            }
        }

        boolean[] visited = new boolean[n];
        
        for(int i = 0; i < n; i++){
            if(visited[i] == true)
                continue;

            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            visited[i] = true;

            while(!q.isEmpty()){
                int cur = q.poll();

                for(int j = 0; j < n; j++){
                    if(visited[j])
                        continue;
                    
                    if(intersect[cur][j]){
                        q.add(j);
                        visited[j] = true;
                    }
                }
            }

            answer++;
        }

        System.out.print(answer);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}