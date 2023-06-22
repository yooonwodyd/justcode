import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        
        if(cacheSize == 0){
            return 5 * cities.length;
        }
        List<String> cache = new ArrayList<>();
        int count = 0;
        for(String city : cities){
            cities[count] = city.toLowerCase();
            count++;
        }
        int answer = 0;
        for(String city : cities){
            if(cache.contains(city)){
                answer += 1;
                cache.remove(cache.indexOf(city));
                cache.add(city);
            }
            else{
                answer += 5;  
                cache.add(city);    
            }
            if(cache.size() > cacheSize){
                cache.remove(0);
            }
        }
        return answer;
    }
}