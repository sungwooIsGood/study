package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11048_이동하기 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
//		내 코드 메모리를 너무 잡아먹었다!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		
//		String[] s = br.readLine().split(" ");
//		
//		int n = Integer.parseInt(s[0]);
//		int m = Integer.parseInt(s[1]);
//
//		int[][] dp  = new int[n][m];
//		
//		String[] ss = br.readLine().split(" ");
//		
//		int temp = 0;
//				
//		for(int i = 0; i < ss.length; i++) {
//			temp += Integer.parseInt(ss[i]);
//			dp[0][i] = temp;
//		}
//		
//		
//		for(int i = 1; i < n; i++) {
//			String[] sss = br.readLine().split(" ");
////			System.out.println(dp[i-1][0]);
//			dp[i][0] = Integer.parseInt(sss[0]) + dp[i-1][0];
//			for(int j = 1; j < m; j++) {
//				dp[i][j] = Integer.parseInt(sss[j])+Math.max(Math.max(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1]);
//				
//			}
//		}
//		
//
//		System.out.println(dp[n-1][m-1]);
		
		
		
		
		String[] s = br.readLine().split(" ");
		
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		
		int[][] dp = new int[n+1][m+1];
		
		int max = -1;
		
		
//		이게 되는 이유
		for(int i = 1; i <= n; i++) {
			
			String[] ss = br.readLine().split(" ");
			
			for(int j = 1; j <= m; j++) {
				
//				dp[i][j] = Integer.parseInt(ss[j-1]);
				
//				왼쪽, 왼쪽대각선, 위
				max = Math.max(dp[i][j-1], Math.max(dp[i-1][j-1], dp[i-1][j]));
				dp[i][j] = Integer.parseInt(ss[j-1]) + max;
			}
		}
		
		System.out.println(dp[n][m]);
	}

}
