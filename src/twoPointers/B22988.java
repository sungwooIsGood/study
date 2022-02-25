package twoPointers;

import java.util.Arrays;
import java.util.Scanner;

public class B22988 {

	// 1초는 대략 1억번 정도 돌아간다.
	// O(n)은 for문 한번 돌리는 의미, 이중for문은 n^2이므로 
	// (1 <= n <= 100000)는 이중포문을 쓰지 말라는 의미
	public static void main(String[] args) {
		
		// 관찰
		// 7 13
		// 0 1 2 3 5 8    13 꽉찬 것은 분리.
		// ex) 1과 2를 가져가면 3리터를 채워주고 총용량인 13의 절반(6.5)을 채워준 9.5리터를 주는 이벤트 중
		
		// 0 을 가져가면 6.5를 가져간다. 그래서 0 0 0개를 가져가면 13짜리 한개를 받을 수 있다.
		// 이미 찬 것들 제외
		// 투포인터로 두개씩 묶어서 제작
		// 남은 것들 // 3이 추가
		
		Scanner sc = new Scanner(System.in);
		
		// 가지고 있는 n개의 병
		int[] arr = new int[sc.nextInt()];
		
		// 13리터를 채울 수 있다는 뜻
		long m = sc.nextLong();

		// 병 안에 용액이 남아있는 병들
		for(int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		int cnt = 0;
		int s = 0;
		int e = arr.length-1;
		int x = 0; // 13리터가 되고 빠진것들을 제외한 남은 용기들을 의미
		
		// 0 1 2 3 5 8    13 꽉찬 것은 분리.
		for(int i = arr.length-1; i >= 0; i--) {
			if(arr[i] == m) {
				cnt++;
				x--;
				e = i - 1;
			}
		}
		
		while (s < e) {
			if(2*(arr[s] + arr[e]) >= m) { //(실수연산되어서) m/2 도 되지만 혹시 모르는 부동소수점으로 인해 2를 먼저 곱해준다.
				cnt++;
				x -= 2;
				s++;
				e--;
			} else {
				s++;
			}
		}
		
		System.out.println((cnt + x) / 3);
	}

}
