package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11052_카드구매하기 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int n = Integer.parseInt(br.readLine());
		
		int[] card = new int[n+1];
		int[] dp = new int[n+1];
		
		String[] s = br.readLine().split(" ");
		
		for(int i = 1; i <= n; i++) {
			card[i] = Integer.parseInt(s[i-1]);
		}
		// 점화식
//		dp[1] = card[1];
//		dp[2] = Math.max(card[1]+card[1], card[2]);
//		dp[3] = Math.max(dp[2]+dp[1], card[3]);
		
		// 전체 n개 loop 돌아보는것
		for(int i = 1; i <= n; i++) {
			// 실제 최대값을 구하는 것
			for(int j = 1; j <= i; j++) {
				// ex) 결국, Math.max(최대가격을 꽉채운 카드팩, 이전값들을 더한 카드팩)
				dp[i] = Math.max(dp[i-j]+card[j], dp[i]);
			}
		}
		System.out.println(dp[n]);
	}

}
