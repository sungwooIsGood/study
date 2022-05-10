package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2609_최대공약수와최소공배수 {

	public static void main(String[] args) throws IOException {

		// 유클리드 호제법
		// 최대 공약수
		// 두 수의 나머지가 0이 될 때까지 계속 나눈다.
		// 90/24 -> 18
		// 24/18 -> 6
		// 18/6 -> 0
		// 최대 공약수는 6
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		int a = Integer.parseInt(s[0]);
		int b = Integer.parseInt(s[1]);
		
		System.out.println(gcd(a,b));
		System.out.println(lcm1(a,b));
//		System.out.println(lcm2(a,b));
		
	}
	// 최대공약수
	// 유클리드 호제법
	public static int gcd(int a, int b) {
		while(b!=0) {
			int r = a % b;
			a = b;
			b = r;
		}
		
		return a;

	}
	// 최소 공배수는 최대공약수를 활용하는 문제 1
	public static int lcm1(int a, int b) {
		
		return a * b / gcd(a,b);
		
	}
	
	// 최소 공배수 문제2
	public static int lcm2(int a, int b) {
		int min = 0;
		
		for(int i = 1; i < 10001; i++) {
			if(i % a == 0 && i % b == 0) {
				min = i;
				break;
			}
		}
		return min;
	}
}
