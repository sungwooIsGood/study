package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B2748_파보나치수2 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		// 점화식
		// Fn = Fn-1 + Fn-2
		
		ArrayList<Long> result = new ArrayList<>();
		
		// 0과 1로 시작한 것
		result.add(0L);
		result.add(1L);
		
		for(int i = 2; i < n+1; i++) {
			result.add(result.get(i-1) + result.get(i-2));
		}
		
		System.out.println(result.get(n));
	}

}
