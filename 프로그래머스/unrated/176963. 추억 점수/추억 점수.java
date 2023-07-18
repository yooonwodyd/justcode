import java.util.*;
class Solution {
    public int[] solution(String[] names, int[] yearning, String[][] photos) {
        int[] answer = new int[photos.length];
        HashMap<String,Integer> namePara = new HashMap<>();
        
        for(int i = 0; i < names.length; i++){
            namePara.put(names[i], yearning[i]);
            
        }
        
        int count = 0;
        for(String[] photo : photos){
            for(String name: photo){
                if(namePara.containsKey(name)){
                    answer[count] += namePara.get(name);
                }
            }
            count++;
        }
        
        return answer;
    }
}