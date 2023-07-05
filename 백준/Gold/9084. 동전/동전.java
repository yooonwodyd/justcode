import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();

            int[] coins = new int[n+1];
            for (int k = 1; k <= n; k++) {
                coins[k] = sc.nextInt();
            }

            int m = sc.nextInt();
            cal(m,coins,n);
        }
    }

    static void cal(int m,int[] coins,int n){
        int[] dp = new int[m+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <=m; j++) {
                if (j - coins[i] > 0) {
                    dp[j] = dp[j] + dp[j-coins[i]];
                } else if (j - coins[i] == 0) {
                    dp[j]++;
                }
            }
        }
        System.out.println(dp[m]);
    }
}