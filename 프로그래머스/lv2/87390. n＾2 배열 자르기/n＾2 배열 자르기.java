class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right - left) + 1];
        int count = 0;
        int x = 0;
        int y= 0;
        for(long i = left; i <= right; i++){
            y = (int)(i / n + 1);
            x = (int)(i % n + 1);
           
            if(y > x){
                answer[count++] = y;
            }
            else{
                answer[count++] = x;
            }
        }
        return answer;
    }

}

// n의 크기 -> 10^7 -> 2차원 배열을 실제로 만들기에는 너무 크다...
// -> 규칙찾기 -> left와 rigth의 x좌표와 y좌표를 찾아 낼 수 있으며 됨.
// -> y 좌표 -> left / n
// -> x 좌표 -> left % n
// -> 해당 좌표의 값 left 와 rigth 중에 더 큰 값.

/*
1 2 3
2 2 3
3 3 3
*/