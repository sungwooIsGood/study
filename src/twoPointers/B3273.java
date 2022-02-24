package twoPointers;

import java.util.Arrays;
import java.util.Scanner;

public class B3273 {
	
	// 9 (배열)
	// 5 12 7 10 9 1 2 3 11  (배열에 속한 수)
	// 13 (x + y = 13)이라는 조건이 만족되는 서로 다른 두 양의 정수
	// ex) 1+12, 10+3, 11+2
	
	// 갯수: 3
	
	// 배열을 먼저 정렬을 해준다.
	// 1 2 3 5 6 7 9 11 12
	// s                 e
	// 13이 되야 하는 수
	// 둘의 합이 13보다 작다면 s가 오른쪽으로 이동한다.
	// 둘의 합이 13이다 그럼 아무거나 이동한다.
	// 둘의 합이 13보다 크다면 e가 왼쪽으로
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[sc.nextInt()];
		
		// 배열 채우기
		for(int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		// 서로다른 양수의 합을 입력하도록 제시.
		int x = sc.nextInt();
		
		// 1. 배열을 정렬한다.
		Arrays.sort(arr);

		// 2. s와 e가 가르키는 포인터를 제시
		int s = 0;
		int e = arr.length-1;
		// 서로다른 양수의 합이 되는 수
		int total = arr[s]+arr[e];
		// 갯수
		int cnt = 0;
		
		// 3. 조건에 따라 포인터가 이동
		while(s < e) {
			if(total < x) {
				s++;
			} else if(total > x) {
				e--;
			} else {
				cnt += 1;
				e--; // or s++; 아무거나 가능
			}
			total = arr[s]+arr[e];
		}
		System.out.println(cnt);
	}

}
