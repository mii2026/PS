// https://www.acmicpc.net/problem/19236 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    int eatMax = 0;

    class Fish{
        int x, y, dir;
        boolean alive;

        public Fish(int x, int y, int dir, boolean alive){
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.alive = alive;
        }
    }

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Fish[] fishes = new Fish[17];
        int[][] arr = new int[4][4];
        
        for(int i = 0; i < 4; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 4; j++){
                int num = Integer.valueOf(st.nextToken());
                int dir = Integer.valueOf(st.nextToken());
                
                arr[i][j] = num;
                fishes[num] = new Fish(i, j, dir-1, true);
            }
        }

        Fish shark = new Fish(0, 0, fishes[arr[0][0]].dir, true);
        int temp = arr[0][0];
        fishes[temp].alive = false;
        arr[0][0] = -1;
        dfs(arr, fishes, shark, temp);

        System.out.println(eatMax);
    }

    public void dfs(int[][] arr, Fish[] fishes, Fish shark, int eatSum){
        eatMax = Math.max(eatMax, eatSum);

        moveFish(arr, fishes);

        for(int i = 1; i < 4; i++){
            int nx = shark.x + i*dx[shark.dir];
            int ny = shark.y + i*dy[shark.dir];

            if(nx < 0 || nx >=4 || ny < 0 || ny >= 4 || arr[nx][ny]==0)
                continue;

            int[][] newArr = new int[4][4];
            for(int j = 0; j < 4; j++){
                for(int k = 0; k < 4; k++){
                    newArr[j][k] = arr[j][k];
                }
            }

            Fish[] newFishes = new Fish[17];
            for(int j = 1; j < 17; j++){
                newFishes[j] = new Fish(fishes[j].x, fishes[j].y, 
                                        fishes[j].dir, fishes[j].alive);
            }

            Fish newShark = new Fish(nx, ny, fishes[arr[nx][ny]].dir, true);
            newArr[shark.x][shark.y] = 0;
            newArr[nx][ny] = -1;
            newFishes[arr[nx][ny]].alive = false;
            dfs(newArr, newFishes, newShark, eatSum+arr[nx][ny]);
        }

    }

    public void moveFish(int[][] arr, Fish[] fishes){
        for(int i = 1; i < 17; i++){
            Fish fish = fishes[i];

            if(!fish.alive)
                continue;
            
            for(int j = 0; j < 8; j++){
                int dir = (fish.dir + j) % 8;
                int nx = fish.x + dx[dir];
                int ny = fish.y + dy[dir];

                if(nx < 4 && nx >= 0 && ny < 4 && ny >= 0 && arr[nx][ny]>-1){
                    if(arr[nx][ny] == 0){
                        arr[fish.x][fish.y] = 0;
                    } 
                    else{
                        int temp = arr[nx][ny];
                        fishes[temp].x = fish.x;
                        fishes[temp].y = fish.y;
                        arr[fish.x][fish.y] = temp;
                    }
    
                    fish.x = nx;
                    fish.y = ny;
                    arr[nx][ny] = i;
                    fish.dir = dir;
                    
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
​