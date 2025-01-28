import java.util.*;
import java.lang.*;
import java.io.*;


class Main {

    public void solution() {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int k = sc.nextInt();

        boolean[] visited = new boolean[100001];
        Deque<int[]> dq = new LinkedList<>();
        dq.add(new int[]{n, 0});
        
        while(!dq.isEmpty()) {
            int[] cur = dq.poll();

            if(cur[0] == k) {
                System.out.print(cur[1]);
                return;
            }

            visited[cur[0]] = true;

            if(cur[0] * 2 <= 100000 && !visited[cur[0] * 2]) {
                dq.addFirst(new int[]{cur[0] * 2, cur[1]});
            } 
            
            if(cur[0] < k && cur[0] + 1 <= 100000 && !visited[cur[0] + 1]) {
                dq.add(new int[]{cur[0] + 1, cur[1] + 1});
            } 
            
            if(cur[0] - 1 >= 0 && ! visited[cur[0] - 1]) {
                dq.add(new int[]{cur[0] - 1, cur[1] + 1});
            }
        }
    }
    
    public static void main(String[] args) {
        new Main().solution();
    }
}