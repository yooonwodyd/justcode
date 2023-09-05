import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] dp = new int[3][2]; // 0은 큰값, 1은 작은값
        int[][] map = new int[N+1][3];
        for(int i = 1; i <= N; i++){
            map[i][0] = sc.nextInt();
            map[i][1] = sc.nextInt();
            map[i][2] = sc.nextInt();
        }

        for(int i = 1; i <= N; i++){
            int maxA,minA,maxB,minB,maxC,minC;
            maxA = Math.max(dp[1][0] + map[i][0],dp[0][0] + map[i][0]);
            minA = Math.min(dp[1][1] + map[i][0],dp[0][1] + map[i][0]);
            maxB = Math.max(Math.max(dp[1][0] + map[i][1],dp[0][0] + map[i][1]),   dp[2][0] + map[i][1]);
            minB = Math.min(Math.min(dp[1][1] + map[i][1],dp[0][1] + map[i][1]),dp[2][1] + map[i][1]);
            maxC = Math.max(dp[1][0] + map[i][2],dp[2][0] + map[i][2]);
            minC = Math.min(dp[1][1] + map[i][2],dp[2][1] + map[i][2]);

            dp[0][0] = maxA;
            dp[0][1] = minA;
            dp[1][0] = maxB;
            dp[1][1] = minB;
            dp[2][0] = maxC;
            dp[2][1] = minC;
        }
        System.out.printf("%d %d",Math.max(Math.max(dp[0][0],dp[1][0]),dp[2][0]),Math.min(Math.min(dp[0][1],dp[1][1]),dp[2][1]));
    }
}