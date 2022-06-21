package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B15649_N과M_1 {
	
	static int n;
	static int m;
	static int[] arr;
	// 중복없이 => 방문여부
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		String[] s = br.readLine().split(" ");
		
		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);
		arr = new int[m];
		visit = new boolean[n];
		
		dfs(0);
		
	}
	
	public static void dfs(int dep) {
		
		if(dep == m) {
			for(int i = 0; i < m; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 0; i < n; i++) {
			if(!visit[i]) {
				visit[i] = true;
				arr[dep] = i+1; // 0=1 , 1=2   /  0=1,  1=3  
				dfs(dep+1);
				visit[i] = false;
			}
		}
	}
}
