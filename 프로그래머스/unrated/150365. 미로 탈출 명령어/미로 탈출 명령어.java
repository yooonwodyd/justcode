import java.util.*;
class Solution {
    public String solution(int n, int m, int y, int x, int r, int c, int k) {
        String[] dir = {"d","l","r","u"};
        //아래,왼,오,위
        int[] dirX = {0,-1,1,0};
        int[] dirY = {1,0,0,-1};
        int distance = cal_dis(x,y,r,c);
        String answer = "";
      
        if(distance > k || k % 2 != distance  % 2){
            return "impossible";
        }
  
        while(true){
           
            if(k == 0){
                break;
            }
            for(int i = 0; i < 4; i++){
                
                if(0 < x + dirX[i] && x + dirX[i] <= m && 0 < y + dirY[i] && y + dirY[i] <= n && cal_dis(x + dirX[i] , y + dirY[i],r,c) <= k){
                    answer += dir[i];
                    x += dirX[i];
                    y += dirY[i];
                    k--;
                    break;
                }
            }
        }
        return answer;
    }
    public int cal_dis(int x, int y, int r, int c){
        return Math.abs(x - c) + Math.abs(y - r);
    }
}


// k는 2500이다.
// 11시 30분 시작.
/* 탈출 못하는 경우는?
1. 도달에 실패하는 경우
2. 짝수, 또는 홀수의 문제.
k = 2500
사전순으로 제일 빠르기 위해서는? dlru 순으로 움직여야한다.
움직이고 나서 생각하는 탐욕법으로 풀자.
start에서 end까지의 최소 거리를 구한다.
최소거리가 k보다 작다면 가능한 dlru순으로 움직인다.
k가 최소거리와 같다면 해당 루트로 움직인다.
이건 bfs 돌리거나,dlru 순으로 x또는 y가 줄어드는 쪽이면 움직이도록하자.
*/