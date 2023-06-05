
import java.util.*;

class Solution {
    static StringBuilder[] arr;
    static boolean[] visited;
    static HashMap<String, ArrayList<Integer>> hash = new HashMap<>();
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        for(String str : info) {
            String[] strArr = str.split(" ");
            visited = new boolean[strArr.length];
            arr = new StringBuilder[strArr.length];

            for(int i = 0; i < strArr.length; i++) {
                arr[i] = new StringBuilder();
                arr[i].append(strArr[i]);
            }
            DFS(0, 0);
        }

        for(String str : hash.keySet()) {
            Collections.sort(hash.get(str));
        }

        StringBuilder sb = new StringBuilder();
        int idx = 0;
        for(String str : query) {
            String[] arr1 = str.split(" and ");
            String[] arr2 = arr1[arr1.length - 1].split(" ");
            int score = Integer.parseInt(arr2[arr2.length - 1]);

            for(int i = 0; i < arr1.length - 1; i++) {
                sb.append(arr1[i]).append(" and ");
            }
            sb.append(arr2[0]);
            ArrayList<Integer> valueList = hash.get(String.valueOf(sb));

            if(valueList == null) {
                answer[idx] = 0;
            } else {
                int pos = BinarySearch(valueList, score);

                if(pos >= 0 && pos <= (valueList.size() - 1)) {
                    answer[idx] = valueList.size() - pos;
                } else {
                    answer[idx] = 0;
                }
            }
            sb.delete(0, sb.length());

            idx++;
        }

        return answer;
    }

    public void DFS(int depth, int idx) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length - 1; i++) {
            sb.append(arr[i]);

            if(i == arr.length - 2) continue;

            sb.append(" and ");
        }
        ArrayList<Integer> list = hash.get(String.valueOf(sb));
        if(list == null) {
            list = new ArrayList<Integer>();
            list.add(Integer.parseInt(String.valueOf(arr[arr.length - 1])));
            hash.put(String.valueOf(sb), list);
        } else {
            list.add(Integer.parseInt(String.valueOf(arr[arr.length - 1])));
        }

        for(int i = idx; i < arr.length - 1; i++) {
            if(!visited[i]) {
                String tmp = String.valueOf(arr[i]);
                arr[i].delete(0, arr[i].length());
                arr[i].append("-");
                visited[i] = true;
                DFS(depth + 1, i + 1);
                arr[i].delete(0, arr[i].length());
                arr[i].append(tmp);
                visited[i] = false;
            }
        }
    }

    public int BinarySearch(ArrayList<Integer> list, int score) {
        int start = 0;
        int end = list.size() - 1;
        int mid = 0;

        while(end >= start) {
            mid = (start + end) / 2;
            if(list.get(mid) < score) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }
}