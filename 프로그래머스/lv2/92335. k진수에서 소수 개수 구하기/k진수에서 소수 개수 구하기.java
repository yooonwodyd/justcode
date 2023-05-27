
class Solution {
    public long check(String a){
        if(a.isBlank() || a.equals("1")){
            return 0;
        }
        long n = Long.parseLong(a);
        if(n == 2){
            return 1;
        }
    
        for(long i = 2; i <= (long)Math.sqrt(n) + 1; i++){
            if(n % i == 0){
                return 0;
            }
        }
    
        return 1;
    }
    public int solution(int n, int k) {
        // True로 시작. 0이 나타나면 그전까지의 수를 저장하기. 담긴 수가 없으면 그냥 가기
        
        int answer = 0;
        String nStr = Integer.toString(n,k) + "0";
        int count = 0;
        String a = "";
        for(char nChar : nStr.toCharArray()){
            if(nChar == '0'){
                answer += check(a);
                a = "";
                continue;
            }
            a += Character.toString(nChar);
        }
        
        System.out.println(nStr);
        return answer;
    }
}

// 10진법으로 보았을 때 소수여야 한다.