package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1182_부분수열의합 {

	static int[] arr;
	static int n; // 정수의 개수
	static int s; // 정수의 합
	static int count; // 개수;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		String[] ss = br.readLine().split(" ");
		
		n = Integer.parseInt(ss[0]);
		arr = new int[n];
		s = Integer.parseInt(ss[1]);
		count = 0;
		
		String[] sss = br.readLine().split(" ");
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(sss[i]);
		}
		
		dfs(0,0);
		
		if(s == 0) {
			System.out.println(count - 1); // s가 0일때
		} else {
			System.out.println(count);
		}
		
	}
	
	public static void dfs(int sum,int idx) {
		
		if(idx == n) {
			if(sum == s) {
				count++;
			}
			return;
		}
//		System.out.println(sum+ " " + idx);
		dfs(sum + arr[idx], idx+1); // 해당 인덱스 더하기
		dfs(sum, idx+1); //해당 인덱스 더하지 않기
	}
}
