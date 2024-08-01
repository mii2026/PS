// https://www.acmicpc.net/problem/3197

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    int R, C;
    char[][] map;
    boolean[][] visited;
    Queue<int[]> swanQueue = new LinkedList<>();
    Queue<int[]> meltQueue = new LinkedList<>();

    int[] xdir = {0, 1, 0, -1};
    int[] ydir = {1, 0, -1, 0};

    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];

        int s1 = 0;
        int s2 = 0;

        for(int i = 0; i < R; i++){
            String str = br.readLine();
            for(int j = 0; j < C; j++){
                map[i][j] = str.charAt(j);

                if(map[i][j] == '.'){
                    meltQueue.add(new int[]{i, j});
                }

                if(map[i][j] == 'L'){
                    meltQueue.add(new int[]{i, j});
                    s1 = i;
                    s2 = j;
                }
            }
        }

        swanQueue.add(new int[]{s1, s2});
        visited[s1][s2] = true;

        int answer = 0;
        do{
            melt();
            answer++;
        }while(!checkMeet());

        System.out.print(answer);
    }

    public boolean checkMeet(){
        Queue<int[]> nextSwan = new LinkedList<>();
        
        while(swanQueue.size() > 0){
            int[] pos = swanQueue.poll();
            
            for(int i = 0; i < 4; i++){
                int nx = pos[0] + xdir[i];
                int ny = pos[1] + ydir[i];
                                
                if(nx < 0 || nx >= R || ny < 0 || ny >= C || visited[nx][ny]){
                    continue;
                }

                if (map[nx][ny] == 'L'){
                    return true;
                }
                else if(map[nx][ny] == 'X'){
                    nextSwan.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
                else{
                    swanQueue.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }

        swanQueue = nextSwan;
        return false;
    }

    public void melt(){
        int size = meltQueue.size();

        for(int i = 0; i < size; i++){
            int[] pos = meltQueue.poll();
            
            for(int j = 0; j < 4; j++){
                int nx = pos[0] + xdir[j];
                int ny = pos[1] + ydir[j];
                                
                if(nx < 0 || nx >= R || ny < 0 || ny >= C || visited[nx][ny]){
                    continue;
                }

                if(map[nx][ny] == 'X'){
                    map[nx][ny] = '.';
                    meltQueue.add(new int[]{nx, ny});
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
​

