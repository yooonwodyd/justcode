import java.util.*;
class Solution {
    public boolean check(String s){
        int count = 0;
        for(char gal : s.toCharArray()){
            if(gal == '('){
                count++;
            }
            else if(gal == ')'){
                count--;
            }
            if(count < 0){
                return false;
            }
        }
        return true;
    }
    public String strSplit(String p){
        if(p.isEmpty() == true){
            return "";
        }
        int open = 0;
        int close = 0;
        int count = 0;
        for(char gal : p.toCharArray()){
            if(gal == '('){
                open++;
            }
            else if(gal == ')'){
                close++;
            }
            if(open == close && open != 0 && close != 0){
                String u = p.substring(0,count+1);
                String v = p.substring(count+1);
         
                
                if(check(u) == true){
                    return u + strSplit(v);
                }
                else if(check(u) == false){
                    String a = "(";
                    a += strSplit(v);
                    a += ")";
                    
                    String b = u.substring(1,u.length()-1);
                    String c = "";
                    for(char bb : b.toCharArray()){
                        if(bb == '('){
                            c += ')';
                        }
                        else{
                            c += '(';
                        }
                    }
                    a += c;
                    return a;
                }
                break;
            }
            count++;
        }
        return "";
    }
    
    public String solution(String p) {
        String an = strSplit(p);    
        return an;
    }
}

