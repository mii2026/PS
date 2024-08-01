import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    String bolcks = "...|.34..21.-..+";
    char[][] arr;
    int r, c;

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new char[r][c];
        for(int i = 0; i < r; i++){
            arr[i] = br.readLine().toCharArray();
        }

        int[] pos = findPos();
        int ans = 0;

        if(pos[0]-1 >= 0 && goDown(arr[pos[0]-1][pos[1]])){
            ans += 1;
        }
        if(pos[0]+1 < r && goUp(arr[pos[0]+1][pos[1]])){
            ans += 2;
        }
        if(pos[1]-1 >= 0 && goRight(arr[pos[0]][pos[1]-1])){
            ans += 4;
        }
        if(pos[1]+1 < c && goLeft(arr[pos[0]][pos[1]+1])){
            ans += 8;
        }

        System.out.printf("%d %d %c", (pos[0]+1), (pos[1]+1), bolcks.charAt(ans));
    }

    public int[] findPos(){
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(goUp(arr[i][j]) && arr[i-1][j] == '.'){
                    return(new int[]{i-1, j});
                }
                else if(goDown(arr[i][j]) && arr[i+1][j] == '.'){
                    return(new int[]{i+1, j});
                }
                else if(goLeft(arr[i][j]) && arr[i][j-1] == '.'){
                    return(new int[]{i, j-1});
                }
                else if(goRight(arr[i][j]) && arr[i][j+1] == '.'){
                    return(new int[]{i, j+1});
                }
            }
        }
        return null;
    }

    public boolean goUp(char c){
        return (c == '|' || c == '+' || c == '2' || c == '3');
    }

    public boolean goDown(char c){
        return (c == '|' || c == '+' || c == '1' || c == '4');
    }

    public boolean goLeft(char c){
        return (c == '-' || c == '+' || c == '3' || c == '4');
    }

    public boolean goRight(char c){
        return (c == '-' || c == '+' || c == '1' || c == '2');
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
​