package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2156_포도주시식 {

	public static void main(String[] args) throws IOException {
		
		// i번째 포도주잔을 마시지않는다, i번째 포도주잔을 첫번째 잔으로 마신다, i번째 포도주 잔을 두번째로 마신다.
		
		// 점화식
		// 00X = dp[i-1]
		// 00X도 알아야하는 이유:
		// 3번째도 마시게 되면 세 번 연속으로 와인을 마실 수는 없기 때문에
		// 첫번째 혹은 두번째 중 하나를 마시고 세번째를 마셔야 하는데 그러면 최대 값이 안 나오기 때문에 안된다. 
		// 0X0 = dp[i-2]+wine[i]
		// X00 = dp[i-3]+wine[i-1]+wine[i]
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] wine = new int[100001];
		int[] dp = new int[100001];
		
		for(int i = 1; i <= n; i++) {
			wine[i] = Integer.parseInt(br.readLine());
		}
			
		dp[1] = wine[1];
		dp[2] = wine[1] + wine[2];
		dp[3] = Math.max(dp[2],Math.max(wine[1]+wine[3],wine[2]+wine[3]));
		
		for(int i = 4; i <= n; i++) {
			// wine[i-1]한 이유 : dp[i-1]은 wine[2]+wine[3]일 수도 있기 때문에
			dp[i] = Math.max(dp[i-1], Math.max(dp[i-3]+wine[i-1]+wine[i],dp[i-2]+wine[i]));
		}
		
		System.out.println(dp[n]);
	}

}
