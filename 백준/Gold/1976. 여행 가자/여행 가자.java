import java.util.*;

public class Main {

    static boolean[] checkPossible;
    public static void main (String[]args){

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] map = new int[N][N];
        checkPossible = new boolean[N];

        Arrays.fill(checkPossible,false);

        ArrayList<Integer>[] arr = new ArrayList[N];
        for(int i = 0; i < N; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                int c = sc.nextInt();
                if(c == 1 || i == j){
                    arr[i].add(j);
                }
            }
        }

        int[] cityToGo = new int[M];


        for(int i = 0; i < M; i++){
            cityToGo[i] = sc.nextInt()-1;
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(cityToGo[0]);

        while(!q.isEmpty()){
            int now = q.poll();

            for(int next : arr[now]){
                if(checkPossible[next] == false){
                    q.add(next);
                    checkPossible[next] = true;
                }
            }
        }

        String answer = "YES";

        for(int city : cityToGo){
            if(checkPossible[city] == false){
                answer = "NO";
                break;
            }
        }

        System.out.println(answer);
    }
}