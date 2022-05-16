package Combinatorics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class B2407_조합 {

	
//	재귀식 - 파스칼 법칙 사용(1)
//	public static void main(String[] args) throws IOException {
//		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		String[] s = br.readLine().split(" ");
//		// n
//		int n = Integer.parseInt(s[0]);
//		// r
//		int m = Integer.parseInt(s[1]);
//		
//		System.out.println(com(n,m));
//	
//	}
//	
//
//	public static Long com(int n, int r) {
//		
//		if(n == r || r == 0) {
//			return 1L;
//		}
//		
//		return com(n-1,r-1) + com(n-1,r);
//	
//	}
	
	
	
	
//	DP 접근(2)
	static BigInteger[][] dp;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		// n
		int n = Integer.parseInt(s[0]);
		// r
		int m = Integer.parseInt(s[1]);
		
		dp = new BigInteger[101][101];
		
		// dp값 넣는 메소드
		com(n,m);
		
		System.out.println(dp[n][m]);
	}

	public static void com(int n, int r) {
		
		for(int i = 1; i <= n; i++) {
			// j는 왜 0부터 시작하냐면 nCr => ex) 4C0 => 1이기 때문에
			for(int j = 0; j <= i; j++) {
				// 조건식
				if(j == 0 || i == j) {
					dp[i][j] = new BigInteger("1");
				} else {
					dp[i][j] = dp[i-1][j-1].add(dp[i-1][j]);
				}
			}
		}
	}
}
