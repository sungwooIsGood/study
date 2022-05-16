package Combinatorics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1010_다리놓기 {

	static int[][] dp = new int[31][31];
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < test; i++) {
			
			// 한 사이트에는 한개의 다리만 놓을 수 있다.
			// 서로 다른 다리가 겹치면 안된다.
			// n <= m, 서로 중복되면 안된다.
			// 조합공식 => nCr
			// 속성 nCr = n-1Cr-1 + n-1Cr 파스칼 법칙
			// r = 0 => 1
			// n = r => 1
			
			String[] s = br.readLine().split(" ");
			
			int n = Integer.parseInt(s[0]);
			int m = Integer.parseInt(s[1]);
			
			System.out.println(combination(m,n));
			
		}
	}
	
	public static int combination(int n, int r) {
		
		if(dp[n][r] > 0) {
			return dp[n][r];
		}
		
		if(n == r || r == 0) {
			return dp[n][r] = 1;
		}
		
		return dp[n][r] = combination(n-1, r-1) + combination(n-1,r);
	} 

}
