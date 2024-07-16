import java.util.*;
import java.io.*;

class Main {

    HashMap<String, Integer> fnum = new HashMap<>();
    HashMap<String, String> parents = new HashMap<>();

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            int f = Integer.parseInt(br.readLine());

            for(int j = 0; j < f; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String n1 = st.nextToken();
                String n2 = st.nextToken();

                if(!parents.containsKey(n1)){
                    parents.put(n1, n1);
                    fnum.put(n1, 1);
                }
                if(!parents.containsKey(n2)){
                    parents.put(n2, n2);
                    fnum.put(n2, 1);
                }

                union(n1, n2);
                
                sb.append(fnum.get(getParent(n1))).append("\n");
            }

            fnum.clear();
            parents.clear();
        }

        System.out.print(sb);
    }

    public String getParent(String str){
        if(parents.get(str) == str)
            return str;

        String parent = getParent(parents.get(str));
        parents.put(str, parent);
        return parent;
    }

    public void union(String str1, String str2){
        String p1 = getParent(str1);
        String p2 = getParent(str2);

        if(p1 != p2){
            parents.put(p2, p1);
            int n = fnum.remove(p2);
            fnum.put(p1, fnum.get(p1) + n);
        }
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
