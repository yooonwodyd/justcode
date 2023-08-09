import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {

        // 1. prioriy q 만들기
        // 3. 실행할 함수?
        // 4. 자신이 다음으로 가게 되는 길에 자기 자신 값 더하기
        // 5. 두번 째 줄 부터 0이면 무시하고 가기. 0보다 크면 똑같이 자기 자신에서 아래 오른쪽으로 자기 자신 + 자신의 왼쪽 더하기

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] map = new int[n][n];
        long[][] answer = new long[n][n];

        for(int i = 0; i < n; i++){
            for(int k = 0; k < n; k++){
                map[i][k] = sc.nextInt();
            }
        }
        answer[0][0] = 1;
        boolean visited[][] = new boolean[n][n];
        visited[0][0] = true;
        for(int i = 0; i < n; i++){
            for(int k = 0; k < n; k++){
                int d = map[i][k];
                if(d == 0){
                    continue;
                }
                if(visited[i][k] == true){
                    if(i + d < n){
                        visited[i+d][k] = true;
                        answer[i+d][k] += answer[i][k];
                    }
                    if(k + d < n){
                        answer[i][k+d] += answer[i][k];
                        visited[i][k+d] = true;
                    }
                }
            }
        }

        System.out.println(answer[n-1][n-1]);

    }
}













