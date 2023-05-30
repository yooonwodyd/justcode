

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Main {
    static int n, m;
    static int[][] map;
    static ArrayList<int[]> home = new ArrayList<>();
    static ArrayList<int[]> chicken = new ArrayList<>();

    static int result = Integer.MAX_VALUE;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];

        // home과 chicken의 좌표를 모두 저장.
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    home.add(new int[]{i, j});
                }
                else if (map[i][j] == 2) {
                    chicken.add(new int[]{i, j});
                }

            }
        }





        boolean[] visit = new boolean[chicken.size()];
        ArrayList<Integer> arr = new ArrayList<>();
        int a = comb(0,0,m,visit,arr);
        System.out.println(a);
        // 조합의 갯수를 뽑는 함수 만들기.

    }
    static public int comb(int start, int depth, int m,boolean[] check_visit, ArrayList<Integer> arr){
        if(depth == m){
            return cal_answer(arr,check_visit);
        }
        int maxx = Integer.MAX_VALUE;
        int su = 0;
        for(int i = start; i < chicken.size(); i++){
            if(check_visit[i] == false){
                arr.add(i);
                check_visit[i] = true;
                su = comb(i,depth+1,m,check_visit,arr);
                maxx = min(su,maxx);
                check_visit[i] = false;
                arr.remove(arr.size()-1);
            }
        }
        return maxx;
    }
    static public int cal_answer(ArrayList<Integer> arr,boolean[] check_visit){
        int[] dis = new int[home.size()];

        for(int i = 0; i < home.size(); i++){
            dis[i] = Integer.MAX_VALUE;
            for(int k = 0; k < chicken.size(); k++){
                if(check_visit[k] == false){

                    continue;
                }

                dis[i] = min(dis[i],cal(home.get(i)[0],home.get(i)[1],chicken.get(k)[0],chicken.get(k)[1]));
            }
        }

        return Arrays.stream(dis).sum();
    }
    static public int cal(int a,int b,int c,int d){

        return Math.abs(a - c) + Math.abs(b - d);
    }
}
