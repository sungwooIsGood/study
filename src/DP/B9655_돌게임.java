package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9655_돌게임 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 점화식
		// 상근 먼저
		// 1 : 1
		// 2 : 1 - 1
		// 3 : 3 or 1 - 1 - 1
		// 4 : 3 - 1, 1 - 3 or 1 - 1 - 1 - 1
		
		// 돌 개수
		int n = Integer.parseInt(br.readLine());
		
		if(n % 2 != 0) {
			System.out.println("SK");
		} else {
			System.out.println("CY");
		}
	}

}
