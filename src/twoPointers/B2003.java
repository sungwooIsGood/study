package twoPointers;

import java.io.IOException;
import java.util.Scanner;

public class B2003 {

	// 투포인터 특징
	// 1. 특정 조건을 만족하는 연속 부분 수열을 찾는다.
	// 2. 특정 조건을 만족하는 두 개의 수를 찾는다.
	// 시간복잡도 O(n)
	// 10 5
	// 1 2 3 4 2 5 3 1 1 2
	// s     
	// e               
	// total: 3
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int arrlength = sc.nextInt();
		
		int[] arr = new int[arrlength];
		
		// 연속 부분 수열의 합과 같음
		int m =  sc.nextInt();
		
		// 배열 채우기
		for(int i = 0; i < arr.length; i++) {
			arr[i] =  sc.nextInt();
		}
		
		
		int s = 0;
		int e = 0;
		
		// 갯수
		int cnt = 0;
		// 연속 부분 수열의 합 ex) 1+2+3 = 6
		int total = arr[0];

		while(e < arrlength) {
			
			if(total == m) {
				cnt += 1;
				e += 1;
				
				if(e == arr.length) {
					break;
				}
				
				total += arr[e];
				
			} else if(total < m) {
				e += 1;
				
				if(e == arr.length) {
					break;
				}
				
				total += arr[e];
				
			} else {
				s += 1;
				total -= arr[s]; // 6-arr[1] = 4      8-arr[2] = 5
			}
			
		}
		System.out.println(cnt);
		
	}

}
