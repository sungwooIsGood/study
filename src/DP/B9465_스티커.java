package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9465_스티커 {

	public static void main(String[] args) throws IOException {
		
		// 0X0
		// 000
		// 점화식
		// 3번째 부터 보면
		// (3,1)이 선택할 경우의 수는 (1,1)+(2,2)+(3,1) // (1,2)+(3,1) // (1,1)+(3,1)
		// (3,2)이 선택할 경우의 수는 (1,2)+(2,1)+(3,2) // (1,1)+(3,2) // (1,2)+(3,2)
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < test; i++) {
			
			int n = Integer.parseInt(br.readLine());

			int[][] card = new int[3][100001];
			int[][] dp = new int[3][100001];
			
			for(int j = 1; j <= 2; j++) {
				String[] s = br.readLine().split(" ");
				for(int k = 1; k <= n; k++) {
					card[j][k] = Integer.parseInt(s[k-1]);
				}
			}
			
			// dp[1]
			dp[1][1] = card[1][1];
			dp[2][1] = card[2][1];
			
			// dp[2]
			dp[1][2] = dp[2][1]+card[1][2];
			dp[2][2] = dp[1][1]+card[2][2];
			
			for(int k = 3; k<=n; k++) {
				dp[1][k] = card[1][k]+Math.max(dp[1][k-2], Math.max(dp[2][k-1],dp[2][k-2]));
				dp[2][k] = card[2][k]+Math.max(dp[2][k-2], Math.max(dp[1][k-1],dp[1][k-2]));
			}
			
			System.out.println(Math.max(dp[1][n],dp[2][n]));
		}
	}

}
