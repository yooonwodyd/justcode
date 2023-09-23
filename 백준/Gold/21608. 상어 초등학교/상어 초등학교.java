import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int answer = 0;
    static ArrayList<Integer>[] likedPeople;
    static int[] dirX = new int[]{0,0,1,-1};
    static int[] dirY = new int[]{1,-1,0,0};
    static int[][] myLo;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        int[][] map = new int[N][N];
        likedPeople = new ArrayList[N * N + 1];
        for(int i = 0; i < N * N + 1; i++){
            likedPeople[i] = new ArrayList<>();
        }


        myLo = new int[N*N+1][2];
        visited = new boolean[N][N];
        // 좋아하는 사람 리스트

        // 현재 주변에 내가 좋아하는 사람의 수를 반환하는 메서드
        // 현재 주변에 비어있는 칸의 개수를 반환하는 메서드

        int[] sun = new int[N*N+1];
        for(int i = 0; i < N * N; i++){
            int student = sc.nextInt();
            sun[i] = student;
            for(int j = 0; j < 4; j++){
                likedPeople[student].add(sc.nextInt());
                myLo[student][0] = i;
                myLo[student][1] = j;
            }
        }


        for(int i = 0; i < N * N; i++){
            cal(map,sun[i]);
        }



        for(int i = 0; i < N; i++){
            for(int k = 0; k < N; k++){
                int a =  around(map,k,i,map[i][k]);

                if(a == 0){
                    answer += 0;
                }
                if(a == 1){
                    answer += 1;
                } else if (a == 2) {
                    answer += 10;
                } else if (a == 3) {
                    answer += 100;
                } else if (a == 4) {
                    answer += 1000;
                }
            }
        }

        System.out.println(answer);

    }



    public static void cal(int[][] map, int student){

        int x = 0;
        int y = 0;
        int maxP = 0;
        int maxSq = -1;
        for(int i = 0; i < N; i++){
            for(int k = 0; k < N; k++){

                if(visited[i][k] == true) continue;

                int aroundP = around(map, k, i, student);
                int EmptySq = howEmpty(map, k, i);


                if(maxP < aroundP){
                    maxP = aroundP;
                    maxSq = EmptySq;
                    x = k;
                    y = i;
                }
                if(maxP <= aroundP && maxSq < EmptySq){
                    maxP = aroundP;
                    maxSq = EmptySq;
                    x = k;
                    y = i;
                }
            }
        }


        map[y][x] = student;
        visited[y][x] = true;
    }

    public static int around(int[][] map, int x, int y, int student){

        int count = 0;
        for(int i = 0; i < 4; i++){
            int nextX = x + dirX[i];
            int nextY = y + dirY[i];

            if(nextX >= 0 && nextY >= 0 && nextX < N && nextY < N){
                for(int k = 0; k < likedPeople[student].size(); k++){
                    if(map[nextY][nextX] == likedPeople[student].get(k)){
                        count++;
                    }
                }
            }
        }

        return count;
    }
    public static int howEmpty(int[][] map, int x, int y) {

        int count = 0;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dirX[i];
            int nextY = y + dirY[i];

            if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < N) {
                if (map[nextY][nextX] == 0) {
                        count++;
                }
            }
        }

        return count;
    }

}
