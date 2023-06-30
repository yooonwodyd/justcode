import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] leftTaller = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] answer = new int[n];
        int count = 0;
        for(int i = 0; i < n; i++){
            int a = leftTaller[i];
            count = 0;
            while(true){
                if(count >= a && answer[count] == 0){
                    answer[count] = i + 1;
                    break;
                }
                else if(answer[count] > i + 1 || answer[count] == 0){
                }
                else{
                    a += 1;
                }
                count += 1;
            }
        }
        System.out.println(Arrays.toString(answer).replaceAll("[\\[\\],]",""));
    }
}
//8 4 7 2 6 1 9 5 10 3
