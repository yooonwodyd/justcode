
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] possibleAttack = {{9,3,1},{9,1,3},{3,9,1},{3,1,9},{1,9,3},{1,3,9}};
    static int answer = 0;
    static String d = "";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        // 정점의 개수, 간선의 개수, 탐색을 시작할 정점의 번호

        // 연결을 기록할 이중배열 하나 만들기.
        ArrayList<Integer>[] map = new ArrayList[N];
        for(int i = 0; i < N; i++){
            map[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a-1].add(b-1);
            map[b-1].add(a-1);
        }
        for(int i = 0; i < N; i++){
            Collections.sort(map[i]);
        }
        d = Integer.toString(V) + " ";
        DFS(map,V-1,new boolean[N]);
        String b = BFS(map,V-1);
        System.out.println(d);
        System.out.println(b);
    }
    static public String DFS(ArrayList<Integer>[] map, int st,boolean[] visited) {

        visited[st] = true;
        for (int i : map[st]) {
            if (visited[i] == false) {
                d += Integer.toString(i+1) + " ";
                DFS(map, i, visited);
            }
        }
        return d;
    }
    static public String BFS(ArrayList<Integer>[] map, int st){
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(st);
        String answer = "";
        boolean visited[] = new boolean[map.length];
        ArrayList<Integer> arr = new ArrayList<>();

        visited[st] = true;
        while(!q.isEmpty()){
            st = q.poll();
            answer += Integer.toString(st+1);
            answer += " ";


            for(int i : map[st]) {
                if(visited[i] == false){
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
        return answer;
    }
}
