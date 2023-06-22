import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        List<String> cache = new ArrayList<>();
        int count = 0;
        for(String city : cities){
            cities[count] = city.toLowerCase();
            count++;
        }
        int answer = 0;
        for(String city : cities){
            boolean check = false;
            for(int i = 0; i < cache.size(); i++){
                if(city.equals(cache.get(i))){
                    answer += 1;
                    cache.remove(i);
                    cache.add(city);
                    check = true;
                    break;
                }
            }
            if(check == false){
                if(cache.size() == cacheSize && cacheSize != 0){
                    cache.remove(0);  
                }
                if(cacheSize != 0){
                    cache.add(city);
                }
                answer += 5;
            }        
        }
        return answer;
    }
}