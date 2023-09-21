import java.io.*;
import java.util.*;

public class Main {

    static int answer = 0;
    static int N;
    static class Node{
        int x;
        int next_x;
        int weight;

        public Node(int x, int next_x, int weight) {
            this.x = x;
            this.next_x = next_x;
            this.weight = weight;
        }
    }


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt()+1;
        ArrayList<Node>[] arr = new ArrayList[N];

        for(int i = 0; i < N; i++){
            arr[i] = new ArrayList<>();
        }
        for(int i = 0; i < N-1; i++){

            int x = sc.nextInt();
            while(true){
                int y = sc.nextInt();
                if(y == -1){
                    break;
                }
                int w = sc.nextInt();
                arr[x].add(new Node(x,y,w));
            }



        }
        int a = bfs(1,arr);
        int b = bfs(a,arr);

        System.out.println(answer);

    }
    static int bfs(int st,ArrayList<Node>[] arr){

        int an = 0;
        int answer_node = 0;
        int[] weight = new int[N];
        boolean[] visited = new boolean[N];
        Queue<Integer> q = new LinkedList<>();
        q.add(st);
        visited[st] = true;


        while(!q.isEmpty()){
            int now = q.poll();
            for(int i = 0; i < arr[now].size(); i++){
                int next = arr[now].get(i).next_x;
                if(visited[next] == false){
                    visited[next] = true;
                    weight[next] += weight[now] + arr[now].get(i).weight;
                    q.add(next);
                    if(weight[next] > weight[answer_node]){
                        an = weight[next];
                        answer_node = next;
                    }
                }
            }
        }
        answer = an;

        return answer_node;
    }

}
