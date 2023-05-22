import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        
        int answer = 0;
        Stack<Integer> doll_stack = new Stack<>();
        for(int move: moves){
            int doll = pick(board,move-1);
            if(doll == 0){
                continue;
            }
            else if(doll_stack.empty() == false && doll_stack.peek() == doll){
                answer = answer + 2;
                doll_stack.pop();
                continue;
            }
            doll_stack.push(doll);
        }
        return answer;
    }
    
    public int pick(int[][] board,int lo){
        for(int i = 0; i < board.length; i++){
            if(board[i][lo] != 0){
                int a = board[i][lo];
                board[i][lo] = 0;
                return a;
            }
        }
        return 0;
    }
}