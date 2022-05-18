package Combinatorics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B6603_로또 {

	static int num;
	static int[] arr;
	static boolean[] check;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		while(true) {
			
			String[] s = br.readLine().split(" ");
			
			// com(n,r)에서 loop돌 때 사용
			num = Integer.parseInt(s[0]);
			arr = new int[num];
			check = new boolean[num];
			
			// 0일때 종료
			if(num == 0) {
				return;
			}
			
			for(int i = 0; i < num; i++) {
				arr[i] = Integer.parseInt(s[i+1]);
			}
			
			// 재귀 시작
			com(0,0);
			System.out.println();
		}
	}
	
	// n => arr의 인덱스 찾기
	// r => count 역할
	public static void com(int n, int r) {
		
		// 재귀 종료식
		if(r == 6) {
			for(int i = 0; i < num; i++) {
				// true 일 때만 arr값 찾기
				if(check[i]) {
					System.out.print(arr[i] + " ");
				}
			}
			System.out.println();

		}
		
		// 재귀 반복
		for(int i = n; i < num; i++) {
			check[i] = true;
			com(i+1,r+1);
			check[i] = false;
		}
	}
}
