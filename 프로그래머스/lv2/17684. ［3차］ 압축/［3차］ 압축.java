import java.util.*;
class Solution {
    public int[] solution(String msg) {
       
        ArrayList<Integer> li = new ArrayList<Integer>();
        System.out.println((int)'A');
        HashMap<String,Integer> map = new HashMap<>();
        for(int i = 'A'; i <= 'Z'; i++){
            char a = (char)i;
            map.put(Character.toString(a),i-64);
        }
        
        msg += "Z";
        int count = 27;
        char[] msgC = msg.toCharArray();
        String now_word= "";
        int now_num = 0;
        String pre_word = "";
        for(int i = 0; i < msg.length(); i++){
            pre_word = now_word;
            now_word += Character.toString(msgC[i]);
            
            if(map.containsKey(now_word) == true){

            }
            else{
                li.add(map.get(pre_word));
                map.put(now_word,count++);
                now_word = Character.toString(msgC[i]);
                
            }
        }
        int[] answer = li.stream().mapToInt(i->i).toArray();
        
        return answer;
    }
}

// 