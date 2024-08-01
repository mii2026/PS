import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {

    public class SegmentTree{
        int[] tree;
        int[] arr;
        int n;

        public SegmentTree(int[] tree, int[] arr){
            this.tree = tree;
            this.arr = arr;
            this.n = arr.length;
        }

        public void init(int idx, int start, int end){
            if(start == end){
                tree[idx] = start;
            } else{
                init(idx*2, start, (start+end)/2);
                init(idx*2+1, (start+end)/2+1, end);

                if(arr[tree[idx*2]] < arr[tree[idx*2+1]]){
                    tree[idx] = tree[idx*2];
                }else{
                    tree[idx] = tree[idx*2+1];
                }
            }
        }

        public long findMax(int start, int end){
            int idx = findIdx(start, end, 0, n-1, 1);
            
            long area = (long)arr[idx] * (end - start + 1);
            
            if(idx-1 >= start){
                area = Math.max(area, findMax(start, idx-1));
            }
            
            if(idx+1 <= end){
                area = Math.max(area, findMax(idx+1, end));
            }
            
            return area;
        }

        public int findIdx(int start, int end, int l, int r, int i){
            if(r < start || l > end){
                return -1;
            }
            if(start <= l && r <= end){
                return tree[i];
            }

            int mid = (l+r)/2;
            int leftNode = findIdx(start, end, l, mid, i*2);
            int rightNode = findIdx(start, end, mid+1, r, i*2+1);

            if(leftNode == -1){
                return rightNode;
            }else if(rightNode == -1){
                return leftNode;
            }else{
                if(arr[leftNode] < arr[rightNode])
                    return leftNode;
                else
                    return rightNode;
            }
        }
    }

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuffer sb = new StringBuffer();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        while(n != 0){
            int size = (int)Math.ceil(Math.log(n)/Math.log(2)) + 1;
            size = (int)Math.pow(2, size);

            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            SegmentTree stree = new SegmentTree(new int[size+1], arr);
            stree.init(1, 0, n-1);
            sb.append(stree.findMax(0, n-1)).append("\n");

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
​