// https://www.acmicpc.net/problem/1039 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public class Node{
        String num;
        int depth;

        Node(String num, int depth){
            this.num = num;
            this.depth = depth;
        }
    }

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        String n = st.nextToken();
        int k = Integer.parseInt(st.nextToken());

        if(n.length() == 1){
            System.out.print(-1);
            return;
        }

        int answer = -1;
        boolean[][] visited = new boolean[k][1000001];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(n, 0));

        while(!q.isEmpty()){
            Node cur = q.poll();
            int depth = cur.depth;
            if(cur.depth == k){
                answer = Math.max(answer, Integer.parseInt(cur.num));
                continue;
            }

            for(int i = 0; i < n.length(); i++){
                for(int j = i + 1; j < n.length(); j++){
                    if(i == 0 && n.charAt(j) == '0'){
                        continue;
                    }

                    String num = swap(cur.num, i, j);
                    
                    if(!visited[depth][Integer.parseInt(num)]){
                        visited[depth][Integer.parseInt(num)] = true;
                        q.add(new Node(num, depth+1));
                    }
                }
            }
        }

        System.out.print(answer);
    }

    public String swap(String num, int i, int j){
        char[] arr = num.toCharArray();
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return String.valueOf(arr);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
