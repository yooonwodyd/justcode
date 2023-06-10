import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[][] cars = new int[10000][2];
        HashMap<Integer,Boolean> map = new HashMap<>();
        
        for(String record: records){
            String[] arr = record.split(" ");
            int time = cal_time(arr[0]);
            int num = Integer.parseInt(arr[1]);
            map.put(num,true);
            if(cars[num][1] == 0){
                cars[num][0] -= time;
                cars[num][1] = 1;
            }
            else{
                cars[num][0] += time;
                cars[num][1] = 0;
            }
        }
        List<Integer> l = new ArrayList<Integer>();
        
        for(int i = 0; i < 10000; i++){
            if(cars[i][0] == 0 && map.containsKey(i) == false){
                continue;
            }
            if(cars[i][1] == 1){
                cars[i][0] += cal_time("23:59");
            }
            if(cars[i][0] <= fees[0]){
                l.add(fees[1]);
            }
            else{
                if((cars[i][0] - fees[0]) % fees[2] != 0){
                    
                    l.add(fees[1] + ((cars[i][0] - fees[0])/fees[2]+1) * fees[3]);
                }
                else{
                    l.add(fees[1] + (cars[i][0] - fees[0])/fees[2] * fees[3]);
                }  
            }
        }
        int[] answer = new int[l.size()];
       
        for(int i = 0; i < l.size(); i++){
            answer[i] = l.get(i);
        }
        return answer;
    }
    
    
    public int cal_time(String record){
        String[] str = record.split(":");
        return Integer.parseInt(str[0]) * 60 + Integer.parseInt(str[1]);
    }
    
}