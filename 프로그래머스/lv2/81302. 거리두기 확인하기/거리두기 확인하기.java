import java.util.*;
 
class Solution {
    static int dx[] = { -1, 1, 0, 0 }; // r c
    static int dy[] = { 0, 0, -1, 1 };
    public static int[] solution(String[][] places) {
        int[] answer = new int[5];

        for (int i = 0; i < 5; i++) {
            String[] p = places[i];
            boolean check = true;
            for (int x = 0; x < 5 && check; x++) {
                for (int y = 0; y < 5 && check; y++) {
                    if (p[x].charAt(y) == 'P') {
                        if (!bfs(x, y, p))
                            check = false;
                    }
                }
            }
            answer[i] = check ? 1 : 0;
        }
 
        return answer;
    }
 
    private static boolean bfs(int x, int y, String[] p) {
        
 
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[] { x, y });
 
        while (!queue.isEmpty()) {
            int[] position = queue.poll();
 
            for (int i = 0; i < 4; i++) {
                int nr = position[0] + dx[i];
                int nc = position[1] + dy[i];
 
                if (nr < 0 || nc < 0 || nr >= 5 || nc >= 5 || (nr == x && nc == y))
                    continue;
 
                int count = Math.abs(nr - x) + Math.abs(nc - y);
 
                if (p[nr].charAt(nc) == 'P' && count <= 2)
                    return false;
                else if (p[nr].charAt(nc) == 'O' && count < 2)
                    queue.offer(new int[] { nr, nc });
            }
        }
 
        return true;
    }
}