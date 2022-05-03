package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;import java.util.Arrays;

public class B12865_평범한배낭 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		// 물품의 수
		int n = Integer.parseInt(s[0]);
		// 버틸 수 있는무게
		int k = Integer.parseInt(s[1]);
		
		int[][] dp = new int[n+1][k+1];
		// 물품의 무게 배열
		// 6, 4, 3, 5
		int[] w = new int[n+1];
		// 물품의 가치 배열
		// 13, 8 ,6, 12
		int[] v = new int[n+1];
		
		for(int i = 1; i <= n; i++) {
			String[] ss = br.readLine().split(" ");
			w[i] = Integer.parseInt(ss[0]);
			v[i] = Integer.parseInt(ss[1]);
		}
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= k; j++) {
				// if문 안에서 전에 무게와 비교하기 위해서
				dp[i][j] = dp[i-1][j]; 
				// 무게가 있는 것을 알기 위해서
				if(j-w[i] >= 0) {
					// 전에 dp값안에 j-w[i]는 무게 0부터 시작한다고 이해하면 쉽다.
					dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-w[i]]+v[i]);
//					System.out.println(j-w[i] + "ddd");
//					System.out.println(dp[i][j]);
				}
			}
		}
		System.out.println(dp[n][k]);
	}

}
