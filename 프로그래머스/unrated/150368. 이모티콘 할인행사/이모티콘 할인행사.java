import java.util.*;
class Solution {
    static int[][] user;
    static int max_user =0;
    static int money = 0;
    static int[] emo;
    public int[] solution(int[][] users, int[] emoticons) {
        user = users;
        emo = emoticons;
        int[] answer = new int[2];
        int[] sale = new int[emoticons.length];
        
        com(0,emoticons.length,sale);
        
        
        answer[0] = max_user;
        answer[1] = money;
    
        return answer;

    }
    
    // 이모티콘 갯수가 정해지면 할인율을 랜덤으로 가져오기.
    public int com(int dep,int len,int[] emo_sale){
        
        if(dep == len){
            cal(emo_sale);
            return 0;
        }
        for(int i = 10; i <= 40; i += 10){
            emo_sale[dep] = i;
            com(dep+1,len,emo_sale);
        }
        return 0;
    }
    
    
    
    public int cal(int[] sale){    
        int[][] now_user = new int[user.length][2];
        for(int i = 0; i < user.length; i++){
            now_user[i][0] = user[i][0];
            now_user[i][1] = user[i][1];
         }
        for(int i = 0; i < sale.length; i++){
            int s = sale[i];
            for(int k = 0; k < user.length; k++){
                if(s >= now_user[k][0]){
                    now_user[k][1] -= emo[i] * (100 - s) / 100;
                }
            
            }
        }
        int count = 0;
        int mo = 0;
        for(int i = 0 ; i < now_user.length; i++){
            
            if(now_user[i][1]  <= 0){
                count++;
            }
            else{
                mo += user[i][1] - now_user[i][1];
            }
        }
        if(count > max_user){
            max_user = count;
            money = mo;
            System.out.println(Arrays.toString(sale));
        }
        else if(count == max_user && mo > money){
            money = mo;
        }
        return 0;
    }
}


/// 이모티콘의 갯수는 최대 7개. 이건 모두 탐색해야할듯?
/// 이모티콘할인율은 4개
//  4의 7승

