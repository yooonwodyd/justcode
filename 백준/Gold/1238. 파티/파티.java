import java.util.*;

public class Main {


    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int X = sc.nextInt();

        int dp[][] = new int[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], 100000000);
            dp[X-1][X-1] = 0;
        }

        for (int m = 0; m < M; m++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int T = sc.nextInt();
            dp[A - 1][B - 1] = T;
        }


        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }
        int max = 0;
        for (int j = 0; j < N; j++) {
            max = Math.max(dp[X-1][j] + dp[j][X-1] , max);
        }

        System.out.println(max);
    }
}
