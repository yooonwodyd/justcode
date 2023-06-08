import java.util.*;
class Solution {
    static int answer = 0;
    static HashMap<String,Integer> map = new HashMap<>();
    static String[] ban_id;
    static boolean[] visited = new boolean[9];
    public int solution(String[] user_id, String[] banned_id) {
        ban_id = banned_id;
        String a = "";
        com(0,banned_id.length,a,user_id);
        
        return answer;
    }
    public int com(int depth, int n, String an, String[] ids){
        if(depth == n){
            String[] str = an.split(" ");
            
            for(int i = 1; i < str.length; i++){
                if(check(str[i],ban_id[i-1]) == false){
                    return 0;
                }
            }

            Arrays.sort(str);
            an = Arrays.toString(str);

            if(map.containsKey(an) == true){
                return 0;
            }
            map.put(an,1);
            
         
            answer++;
            return 1;
        }
        
        for(int i = 0; i < ids.length; i++){
            if(visited[i] == false){
                visited[i] = true;
                com(depth+1, n, new String(an + " " + ids[i]), ids);
                visited[i] = false;
            }
        }
        return 0;
    }
    
    public boolean check(String id, String ban_id){
        if(id.length() == ban_id.length()){
            for(int i = 0; i < id.length(); i++){
                if(id.charAt(i) == ban_id.charAt(i) || ban_id.charAt(i) == '*'){
                    
                }
                else{
                    break;
                }
                if(i == id.length() - 1){
                    return true;
                }
            }
        }
        return false;
    }
}

