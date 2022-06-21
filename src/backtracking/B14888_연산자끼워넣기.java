package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B14888_연산자끼워넣기 {

	static int n;
	static int[] arr;
	static int[] operator;
	static int max;
	static int min;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		operator = new int[4];
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		
		String[] s = br.readLine().split(" ");
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(s[i]);
		}
		
		String[] ss = br.readLine().split(" ");
		
		for(int i = 0; i < 4; i++) {
			operator[i] = Integer.parseInt(ss[i]);
		}
		
		// 백트레킹
		// 비교할 최초숫자, 인덱스
		dfs(arr[0],1);
		System.out.println(max);
		System.out.println(min);
	}	
	
	public static void dfs(int num, int idx) {
		
		// 백트레킹 종료
		if(idx == n) {
			max = Math.max(max, num);
			min = Math.min(min, num);
		}
		
		for(int i = 0; i < 4; i++) {
			
			if(operator[i] > 0) {
				operator[i]--;
				switch(i) {
					case 0 :
						dfs(num+arr[idx],idx+1);
						break;
					case 1 : 
						dfs(num-arr[idx],idx+1);
						break;
					case 2 :
						dfs(num*arr[idx],idx+1);
						break;
					case 3 :
						dfs(num/arr[idx],idx+1);
						break;
				}
				// 재귀 끝날 때마다 값을 복구 시킨다.
				operator[i]++;
			}
		}
	}
}