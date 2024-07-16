import java.util.Scanner;

class Main {

    public void solution() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        if(k > (n+"").length()) {
            System.out.print("1023456789".substring(0, k));
        } else {
            for(int i = n+1; i < 1000000000; i++){
                if(check(i) == k){
                    System.out.print(i);
                    break;
                }
            }
        }
    }

    public int check(int n){
        boolean[] arr = new boolean[10];
        int num = 0;

        while(n > 0){
            if(!arr[n%10]){
                arr[n%10] = true;
                num++;
            }
            n /= 10;
        }
        return num;
    }

    public static void main(String[] args) {
        new Main().solution();
    }
}