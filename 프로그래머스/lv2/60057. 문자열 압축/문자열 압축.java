import java.util.*;
class Solution {
    public int solution(String s) {
        
       
        HashMap<String,Integer> map = new LinkedHashMap<>();
        int min = Integer.MAX_VALUE;
        int minI = 0;
        
        String now = "";
        for(int i = 1; i <= s.length(); i++){
            String a = "";
            int count = 0;
            int str_count = 0;
            int now_count = 1;
            
            
            
            
            for(char c : s.toCharArray()){
                a += Character.toString(c);
                
            
                if(a.length() == i){
                    if(now.equals(a)){
                        now_count++;
                        if(Integer.toString(now_count-1).length() != Integer.toString(now_count).length() || now_count == 2){
                        count++;
                        }
                    }
                    else{
                        count += i;
                        now = a;
                        now_count = 1;
                    }
              
                    a = "";
                }
            }
            
            
            int len = count + (s.length() % i);
    
            
   
            if(len <= min){
                min = len;
                minI = i;
            }
        }
     
        int answer = min;
        return answer;
    }
}