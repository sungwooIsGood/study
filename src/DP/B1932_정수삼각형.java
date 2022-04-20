package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1932_정수삼각형 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 점화식
		// n, n+1
		
		// 높이
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		int[][] dp = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			
			String[] s = br.readLine().split(" ");
			
			for(int j = 0; j <= i; j++) {
				arr[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		// 정수 꼭대기 값
		dp[0][0] = arr[0][0];
		
		// 맨왼쪽
		for(int i = 1; i < n; i++) {
			dp[i][0] = dp[i-1][0] + arr[i][0];
		}
		
		// 위에 두 값을 비교
		for(int i = 1; i < n; i++) {
			for(int j = 1; j <= i; j++) {
				dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + arr[i][j];
			}
		}
		
		// 맨 마지막 줄 가장 큰 값
		int max = 0;
		for(int i = 0; i < n; i++) {
			max = Math.max(dp[n-1][i],max);
		}
		System.out.println(max);
	}

}
