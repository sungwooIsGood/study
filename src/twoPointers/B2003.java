package twoPointers;

import java.io.IOException;
import java.util.Scanner;

public class B2003 {

	// 투포인터 특징
	// 1. 특정 조건을 만족하는 '연속 부분 수열'을 찾는다.
	// s와e는 0에서 부터 시작, 반복조건 e < arr.length보가 작아야한다, 같이 뒤로간다

	// 2. 특정 조건을 만족하는 '두 개의 수'를 찾는다.
	// s는 0, e는 arr-1에서 출발, 반복조건 s < e, 서로에게 다가간다.
	// 시간복잡도 O(n)
	
	
	// 10 5
	// 1 2 3 4 2 5 3 1 1 2
	// s     
	// e               
	// total: 3
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 뒤에 빈공간을 하나 더만 들어서 e가 10 이상을 가도 바운드 오류가 되는 것을 방지
		int[] arr = new int[sc.nextInt()+1]; 
		
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

		while(e < arr.length) {
			
			if(total == m) {
				cnt += 1;
				e += 1;
				
//				if(e == arr.length) {
//					break;
//				}
				
				total += arr[e];
				
			} else if(total < m) {
				e += 1;
				
//				if(e == arr.length) {
//					break;
//				}
				
				total += arr[e];
				
			} else {
				s += 1;
				total -= arr[s]; // 6-arr[1] = 4      8-arr[2] = 5
			}
			
		}
		System.out.println(cnt);
		
	}

}
