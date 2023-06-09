import java.util.*;
class Solution {
    public List solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        HashMap<String,Integer> map = new HashMap<>();
        
        for(String t : terms){
            String[] c = t.split(" ");
            map.put(c[0],Integer.parseInt(c[1]));
        }
        int[] end_days = new int[privacies.length];
        
        int count = 0;
        for(String p : privacies){
            String[] pv = p.split(" ");
            
            end_days[count] = day_cal(pv[0]) + map.get(pv[1]) * 28;
            count++;
        }
        
        int now_day = day_cal(today);
        
        count = 0;
        for(int ed: end_days){
            if(ed <= now_day){
                answer.add(count+1);
            }
            count++;
        }
        return answer;
    }
    
    public int day_cal(String str){ 
        //str = 2021.05.02
        String[] dayArr = str.split("[.]");
      
        int year = Integer.parseInt(dayArr[0]);
        int mon = Integer.parseInt(dayArr[1]);
        int day = Integer.parseInt(dayArr[2]);
        return year * 28 * 12 + mon * 28 + day;
    }
}



