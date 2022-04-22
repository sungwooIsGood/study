package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11727_2Xn타일링2 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 점화식
		// 2*0 = 0
		// 2*1 = 1
		// 2*2 = 3
		
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[1001];
		
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 3;
		
		for(int i = 3; i <= n; i++) {
			dp[i] = ((dp[i-1]+dp[i-2]+dp[i-2])%10007);
		}
		System.out.println(dp[n]);
	}

}
