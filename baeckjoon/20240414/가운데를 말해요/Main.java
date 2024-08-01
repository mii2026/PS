// https://www.acmicpc.net/problem/1655 

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.PriorityQueue;
import java.util.Collections;

public class Main {
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.valueOf(br.readLine());

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int num, median = 0;

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++){
            num = Integer.valueOf(br.readLine());
            
            if(i == 0){
                median = num;
            }
            else if(i % 2 == 1){
                if(num >= median){
                    minHeap.offer(num);
                }
                else{
                    maxHeap.offer(num);
                    minHeap.offer(median);
                    median = maxHeap.poll();
                }
            }
            else{
                if(num <= median){
                    maxHeap.offer(num);
                }
                else{
                    minHeap.offer(num);
                    maxHeap.offer(median);
                    median = minHeap.poll();
                }
            }
            sb.append(median).append("\n");
        }

        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
