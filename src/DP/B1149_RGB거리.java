package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1149_RGB거리 {

	public static void main(String[] args) throws IOException {
		// 점화식 조건
		// 1번 집의 색은 2번 집의 색과 같지 않아야 한다.
		// n번 집의 색은 n-1번 집의 색과 같지 않아야한다.
		// i(2<=i<=n-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야한다.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int n = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[n+1][4];
		
		for(int i = 1; i <= n; i++ ) {
			
			String[] s = br.readLine().split(" ");
			for(int j = 1; j <= 3; j++) {
				dp[i][j] = Integer.parseInt(s[j-1]);
			}
		}
		
		// 집이 하나 일 때
		// 3개의 RGB값 중 최소값 하나 선택
		// 집이 두개 일 때
		// RG,RB / GR,GB / BR,BG 중 최소값
		// 집이 세개 일 때
		// dp[2] + 집이 두개일 때 연속된 색을 제외한 최소값
		// *******   dp[i] = dp[i-1] + 전의 최소값               ********
		for(int i = 1; i <= n; i++) {
			dp[i][1] = Math.min(dp[i][1]+dp[i-1][2],dp[i][1]+dp[i-1][3]);
			dp[i][2] = Math.min(dp[i][2]+dp[i-1][1],dp[i][2]+dp[i-1][3]);
			dp[i][3] = Math.min(dp[i][3]+dp[i-1][1],dp[i][3]+dp[i-1][2]);
	}
		System.out.println(Math.min(Math.min(dp[n][1], dp[n][2]),dp[n][3]));
	}

}
