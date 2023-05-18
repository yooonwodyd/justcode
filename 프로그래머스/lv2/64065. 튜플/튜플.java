import java.util.*;

class Solution {
    class TT implements Comparable<TT>{
        int num;
        int count_num;
        
        TT(int num, int count_num){
            this.num = num;
            this.count_num = count_num;
        }
        @Override
        public int compareTo(TT tt){
            return tt.count_num - this.count_num;
        }
        
    }
    public int[] solution(String s) {
        int[] count_n = new int[100001];
        String[] c = s.split("[^0-9]");
        for(String i : c){
            if(!i.isEmpty()){
                count_n[Integer.parseInt(i)] += 1;
            }
        }

        
        
        ArrayList<TT> arr = new ArrayList<>();
        
        for(int i = 1; i <= 100000; i++){
            if(count_n[i] != 0){
                arr.add(new TT(i,count_n[i]));
            }
        }
        int[] answer = new int[arr.size()];
        
        Collections.sort(arr);
        
        int count = 0;
        for(TT i:arr){
            answer[count] = i.num;
            count++;
        }
        
        return answer;
    }
}