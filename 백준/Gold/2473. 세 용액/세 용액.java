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

        Arrays.sort(liquid);
        Long answer = Long.MAX_VALUE;
        int l = 0;
        int t = 0;
        int m = 0;


        for(int i = 0; i < n; i++){
            int middle = i;
            int top = i + 1;
            int low = i - 1;

            while(low >= 0 && top <= n-1){
                Long mixed = (long) (liquid[low] + liquid[top]) +(long) liquid[middle];

                if(answer > Math.abs(mixed)){
                    l = liquid[low];
                    t = liquid[top];
                    m = liquid[middle];
                    answer = Math.abs(mixed);
                }
                if(mixed > 0){
                    low--;
                }
                else{
                    top++;
                }
            }
        }


        System.out.printf("%d %d %d",l,m,t);
    }
}