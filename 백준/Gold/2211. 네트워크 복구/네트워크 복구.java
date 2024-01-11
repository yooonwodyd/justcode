import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.*;

public class Main {
    // 다익스트라 구현

    static class Node{
        int idx;
        int cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 정점의 개수
        int m = sc.nextInt(); // 간선의 개수

        ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
        for(int i = 0; i < n+1; i++){
            graph.add(new ArrayList<Node>());
        }
        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt();
            graph.get(a).add(new Node(b, cost));
            graph.get(b).add(new Node(a, cost));
        }
        int[] visited = new int[n + 1];
        int[] dist = new int[n + 1];

        for(int i = 0; i < n + 1; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<Node> q = new PriorityQueue<Node>(((o1, o2) -> Integer.compare(o1.cost, o2.cost)));
        q.offer(new Node(1, 0));

        while(!q.isEmpty()){
            Node node = q.poll();
            int now_idx = node.idx;
            int now_cost = node.cost;

            if(dist[now_idx] < now_cost) continue;

            for(int i = 0; i < graph.get(now_idx).size(); i++){
                int next_idx = graph.get(now_idx).get(i).idx;
                int next_cost = graph.get(now_idx).get(i).cost + now_cost;
                if(dist[next_idx] > next_cost){
                    visited[next_idx] = now_idx;
                    dist[next_idx] = next_cost;
                    q.offer(new Node(next_idx, next_cost));
                }
            }
        }
        System.out.println(n - 1);
        boolean[][] check = new boolean[n + 1][n+1];
        for(int i = 0; i < visited.length; i++){
            if(visited[i] != 0 && !check[i][visited[i]]){
                check[visited[i]][i] = true;
                System.out.println(i + " " + visited[i]);
            }
        }
    }

    public static void dijkstra(){

    }
}