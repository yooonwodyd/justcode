import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
	public static int[] dp;
	public static int N;
	public static int K;
	static void updateDp(int w, int v){
		for(int i = K; i >= w; i--){
			// w 보다 무거운 경우 중에,  [i - w]  + V 가 [i] 보다 크다면 변경하기
			if(dp[i - w] + v > dp[i]) {
				dp[i] = dp[i-w] + v;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		K = Integer.parseInt(input[1]); // 물품의 수, 총 무게

		dp = new int[K+1];

		for(int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			int W = Integer.parseInt(input[0]);
			int V = Integer.parseInt(input[1]);
			updateDp(W,V);
		}

		System.out.println(dp[K]);
	}
}