import java.util.*;
class Solution {
    public String[] solution(String[] files){
        
        String[] answer = new String[files.length];
        String[] answer_sort = new String[files.length];
        HashMap<String,String> map = new HashMap<>();
        
        int count = 0;
        for(String file: files){
            String imsi = file;
            boolean check = true;
            String num = "";
            file.toLowerCase();
            for(char a : file.toCharArray()){
                if((int)'0' <= (int)a && (int)a <= (int)'9'){
                    check = false;
                    num += Character.toString(a);
                    continue;
                }
                else if(check == false){
                    break;
                }
                num += Character.toString(a);
            
            }
            map.put(num,imsi);
            answer_sort[count] = num;
            count++;
        }
        
        Arrays.sort(answer_sort);
        
        System.out.println(Arrays.toString(answer_sort));
        count = 0;
        for(String a : answer_sort){
            answer[count] = map.get(a);
            count++;
        }
        return answer;
    }
}