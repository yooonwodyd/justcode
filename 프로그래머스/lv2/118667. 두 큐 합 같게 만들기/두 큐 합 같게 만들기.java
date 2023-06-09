import java.util.*;
class Solution {

    public Long solution(int[] queue1, int[] queue2) {
        Long sum1 = 0L;
        Long sum2 = 0L;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        for(int q : queue1){
            sum1 += q;
            q1.add(q);
        }
        for(int q : queue2){
            sum2 += q;
            q2.add(q);
        }
        int imsi = 0;
        int len = (queue1.length + queue2.length )* 10;
        for(Long i = 0L; i < len; i++){
            if(sum1 < sum2){
                imsi = q2.poll();
                q1.add(imsi);
                sum1 +=imsi;
                sum2 -= imsi;
            }
            else if(sum1 > sum2){
                imsi = q1.poll();
                q2.add(imsi);
                sum2 +=imsi;
                sum1 -= imsi;
            }
            else{
                return i;
            }
        }
        
        Long answer = -1L;
        return answer;
    }
    
}