package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B11726_2Xn타일링 {

	public static void main(String[] args) throws IOException {

		// 점화식 : 이전값을 구할 수 있는 방법
		// 1. 아이디어
		// 점화식 : An = An-1 + An-2
		// N값을 구하기 위해, for문 2부터 N까지의 값을 구해주기
		// 이전값, 이전이전값 더해서, 10007로 나눠서 저장
		
		// 2. 시간복잡도
		// O(N)
		
		// 3. 자료구조
		// dp값 저장하는 (경우의 수) 배열 : int[]
		// 최대값 : 10007보다 작음 -> int
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
	
		// 2X3까지 경우의 수  2X3은 2X1과 2X2를 이용하였음.
		ArrayList<Integer> result = new ArrayList<>();
		
		// 경우의 수를 넣은 것임.
		// 2X0인 경우
		result.add(0);
		// 2X1인 경우
		result.add(1);
		// 2X2인 경우
		result.add(2);
		
		// 2X3은 2X1과 2X2를 이용한 것임.
		for(int i = 3; i < n+1; i++) {
			result.add((result.get(i-1) + result.get(i-2))%10007);
		}
		
		System.out.println(result.get(n));
	}

}
