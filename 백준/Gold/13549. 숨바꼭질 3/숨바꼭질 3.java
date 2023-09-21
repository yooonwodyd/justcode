import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {


        int count = 0;

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] cost = new int[200001];
        boolean[] visited = new boolean[200001];
        Arrays.setAll(cost, x -> Math.abs(x - N));


        PriorityQueue<int[]> pq = new PriorityQueue<>(
                new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        return o1[1] - o2[1];
                    }
                }
        );

        pq.add(new int[]{N,cost[N]});

        while(!pq.isEmpty()){
            int[] node = pq.poll();
            int now_cost = node[1];
            int now = node[0];

            if(visited[now] == true) continue;

            visited[now] = true;
            if(now - 1 >= 0 && now_cost + 1 < cost[now - 1]){
                cost[now - 1] = now_cost + 1;
            }
            if(now + 1 <= K * 2 && now_cost + 1 < cost[now + 1]){
                cost[now + 1] = now_cost + 1;
            }
            if(now * 2 <= K * 2 && now_cost < cost[now * 2]){
                cost[now * 2] = now_cost;
            }
            if(now - 1 >= 0) {
                pq.add(new int[]{now - 1, cost[now - 1]});
            }
            if(now + 1 <= K * 2){
                pq.add(new int[]{now+1,cost[now+1]});
            }
            if(now * 2 <= K * 2){
                pq.add(new int[]{now * 2,cost[now * 2]});
            }


        }

        System.out.println(cost[K]);
    }

}

