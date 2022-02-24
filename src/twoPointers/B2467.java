package twoPointers;

import java.util.Arrays;
import java.util.Scanner;

public class B2467 {
	
	// 합이 양수면 e가 앞으로
	// 합이 음수면 s가 앞으로
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[sc.nextInt()];
		
		// 배열 채우기
		for(int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		// 정렬을 반드시 해주어야 한다.
		Arrays.sort(arr);
		
		int s = 0;
		int e = arr.length-1;
		
		// 두수의 값 초기화 
		int x = arr[s];
		int y = arr[e];
		
		// Math.abs()는 절대값
		while(s < e) {
			if(Math.abs(x+y) > Math.abs(arr[s] + arr[e])) {
				x = arr[s];
				y = arr[e];
			}
			
			if(arr[s] + arr[e] < 0) {
				s++;
			} else {
				e--;
			}
		}
		System.out.print(x + " " + y);
	}

}
