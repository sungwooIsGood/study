package Combinatorics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11050_이항계수1 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		String[] s = br.readLine().split(" ");
		
		int n = Integer.parseInt(s[0]);
		int k = Integer.parseInt(s[1]);
		
		// nCk = n! / ((n-k)! * k!)
		System.out.println(factorial(n) / (factorial(n - k) * factorial(k)));
		
	}
	
	public static int factorial(int n) {
		
		if(n <= 1) {
			return 1;
		} else {
			
			return n * factorial(n-1); 
		}
	}

}
