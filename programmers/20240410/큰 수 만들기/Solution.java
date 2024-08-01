class Solution {
    public String solution(String number, int k) {
        char[] stack = new char[number.length()];
        int head = 0;
        int out = 0;
        
        for(char c: number.toCharArray()){
            while(k > out && head > 0 && stack[head-1] < c){
            	head--;
                out++;
            }
            stack[head++] = c;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < number.length()-k; i++){
            sb.append(stack[i]);
        }
        return sb.toString();
    }
}