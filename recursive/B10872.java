package baekjun;

import java.util.Scanner;

// 팩토리얼 재귀
public class B10872 {

	static int one = 1;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int factorial = recursive(num);
		
		System.out.println(factorial);
	}
	
	static int recursive(int num) {
			
			if(num <= 1) {
				return one;
			}  else {
				num *= recursive(num-1);
				return num;
			}
	}

}

