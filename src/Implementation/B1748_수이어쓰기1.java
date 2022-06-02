package Im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1748_수이어쓰기1 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
	
		int result = 0;
		// 10-> 100 -> 1000 ... 10의 배수로 증가 할 때마다 cnt 개수 1개 증가
		int cnt = 1;
		// 1 ~ 9 = 9개
		// 10 ~ 99 = 90개
		// 100 ~ 999 = 900개
		
		// 10의 자리 마다 10씩 곱해준다
		int len = 10;
		
		// 10 => 11
		// 11 => 13
		// 12 => 15
		for(int i = 1; i <= n; i++) {
			
			if(i == len) {
				len *= 10;
				cnt += 1;
			}
			
			result += cnt;
		}
		
		System.out.println(result);
	}

}
