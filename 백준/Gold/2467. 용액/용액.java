import java.util.*;

public class Main {
    public static void main (String[]args){


        // 1.low
        // 2. high
        // 3.Liquid[low] + Liquid[high]의 값?
        // 만약 0보다 작다면 hith를 한단계 올리고
        // 만약 0보다 크다면 low를 한단계 내린다.

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] liquid = new int[n];

        // 용액에 값  넣기
        for(int i = 0; i < n; i++){
            liquid[i] = sc.nextInt();
        }

        int cp = 0;
        int top = 0;
        int low = 0;
        int answer = Integer.MAX_VALUE;
        for(int i = 0; i < n - 1; i++){
            if(Math.abs(liquid[i+1] + liquid[i]) < Math.abs(answer)){
                answer = liquid[i+1] + liquid[i];
                low = i;
                top = i+1;
            }
        }
            int a = 0;
            int b = 0;
            answer = Integer.MAX_VALUE;
            while(low >= 0 && top <= n-1){
                // 3.Liquid[low] + Liquid[high]의 값?
                // 만약 0보다 작다면 hith를 한단계 올리고
                // 만약 0보다 크다면 low를 한단계 내린다.
                int mixed = liquid[low] + liquid[top];

                if(answer > Math.abs(mixed)){
                    a = liquid[low];
                    b = liquid[top];
                    answer = Math.abs(mixed);
                }

                if(mixed > 0){
                    low--;
                }
                else{
                    top++;
                }
            }
            System.out.printf("%d %d",a,b);
        }
}