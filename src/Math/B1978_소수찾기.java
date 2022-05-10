package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1978_소수찾기 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		// 소수 개수
		int count = 0;
		
		// 소수 배열
		int[] arr = new int[n];
		
		String[] s = br.readLine().split(" ");
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(s[i]);
		}

		for(int i = 0; i < n; i++) {
			
			int sosuCnt = 0;
			
			// 1은 제외, 1은 소수가 아니다.
			for(int j = 2; j <= arr[i]; j++) {
				if(arr[i] % j == 0) {
					sosuCnt++;
				}
			}
			
			// 1과 자기자신인 소수 일 때 알 수 있는 조건
			if(sosuCnt == 1) {
				count++;
			}
		}
		System.out.println(count);
	}

}
