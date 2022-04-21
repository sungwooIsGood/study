package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2579_계단오르기 {

	public static void main(String[] args) throws IOException {

		// 점화식
		// top - bottom
		// n - n-1 - n-3
		// n - n-2
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] rank = new int[n+1];
		
		for(int i = 1; i <= n; i++) {
			rank[i] = Integer.parseInt(br.readLine());
		}
		
		int[] dp = new int[n+1];
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		
//		// 경우의 수
//		dp[1] = rank[1];
//		dp[2] = Math.max(rank[1]+rank[2],rank[2]);
//		dp[3] = Math.max(rank[1]+rank[3], rank[2]+rank[3]);
//		
//		for(int i = 4; i <= n; i++) {
//			dp[i] = rank[i] + Math.max(dp[i-3]+rank[i-1], dp[i-2]);
//		}
//		
//		System.out.println(dp[n]);
	}

}
