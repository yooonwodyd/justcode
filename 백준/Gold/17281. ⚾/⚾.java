import java.util.*;
import java.io.*;

class Main {
    static int[][] result;
    static boolean[] players;
    static int answer = -1;
    static int N;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 현재 이닝 수
        result = new int[9][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < 9; j++){
                result[j][i] = sc.nextInt();
            }
        }
        int[] turn = new int[9];
        players = new boolean[9];

        DFS(0,turn);
        System.out.println(answer);
    }

    private static int DFS(int depth,int[] a) {
        if(depth == 3){
            a[depth] = 0;
            DFS(depth+1,a);
        }
        if(depth == 9){
            answer = Math.max(answer,cal(a));
        }
        for(int i = 1; i < 9; i++){
            if(players[i]) continue;
            a[depth] = i;
            players[i] = true;
            DFS(depth+1,a);
            players[i] = false;
        }

        return 0;
    }

    private static int cal(int[] a) {
        int st = 0;
        int jumsu = 0;

        for(int innings = 0; innings < N; innings++){
            int[] personalScore = new int[9];
            int outCount = 0;

            while(outCount != 3){
                int now = st % 9;
                int t = result[a[now]][innings];
                    if(t == 0) outCount++;
                    else run(personalScore,t, now);

                    for (int j = 0; j < 9; j++) {
                        if (personalScore[j] >= 4) {
                            jumsu++;
                            personalScore[j] = 0;
                        }
                    }
                    st++;
                }
            }
        return jumsu;
    }

    private static void run(int[] personalScore, int x, int i) {
        for (int j = 0; j < 9; j++) {
            if (personalScore[j] > 0) {
                personalScore[j] += x;
            }
        }
        personalScore[i] += x;
    }
}