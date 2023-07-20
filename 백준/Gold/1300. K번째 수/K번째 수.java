import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int K = in.nextInt();

        long front = 1;
        long end = K;

        while(front < end){
            long mid = (end+front) / 2;
            long answer = 0;



            for(int i = 1; i <= N; i++){
                answer += Math.min(mid / i,N);
            }


            if(K <= answer){
                end = mid;
            }
            else{
                front = mid + 1;
            }
        }
        System.out.println(front);
    }
}