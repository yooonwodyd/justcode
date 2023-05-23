import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        
        String[] answer = new String[record.length];
        
        HashMap<String,String> Id_nick = new HashMap<>();
  
        int count = 0;
        for(int i = 0; i < record.length; i++){
            String[] a = record[i].split(" ");
        
            if(a[0].equals("Enter") == true){
                answer[count] = "님이 들어왔습니다.";
                Id_nick.put(a[1],a[2]);
                count++;
            }
            else if(a[0].equals("Leave") == true) {
                answer[count] = "님이 나갔습니다.";
                count++;
            }
            else{
                Id_nick.put(a[1],a[2]);
            }
        }
        String[] real = new String[count];
        count = 0;
         for(int i = 0; i < record.length; i++){
             String[] a = record[i].split(" ");
            if(a[0].equals("Change") == true) {
                continue;
            }
            real[count] = Id_nick.get(a[1]) + answer[count];
             count++;
         }
        
            
           
    return real;
        
    }

}

// 
// 아이디는 언제 나갔고 들어왔는지 들어와 있음
// 아이디와 일대일로 매칭되는 배열에서 닉네임을 들고 있음.