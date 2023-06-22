import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        // 맵에 의상의 갯수의 수 만큼 ++ 하기
        // 각 의상의 갯수 + 1 개 를 모두 곱하고 -1 하기.
        int answer = 1;
        HashMap<String,Integer> map = new HashMap<>();
        
        for(String[] cloth : clothes){
            if(
                map.containsKey(cloth[1])
              ){
                map.put(cloth[1],map.get(cloth[1]) + 1);
            }
            else{
                map.put(cloth[1],1);
            }
        }
        for(int i : map.values()){
            answer *= i + 1;
        }
        return answer-1;
    }
}