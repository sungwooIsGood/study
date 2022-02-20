package recursive;

import java.util.Scanner;

// 피보나치수 재귀
public class B2747 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		System.out.println(fibonacci(num));
		
	}
	
	static int fibonacci(int num) {
		
		if(num == 0) {
			return 0;
			
		} else if(num == 1 || num == 2) {
			return 1;
				
		} else {
			return fibonacci(num-1) + fibonacci(num-2);
		}
	}

}
