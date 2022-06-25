package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B15652_N과M_4 {
	

	static int[] arr;
	static boolean[] visit;
	static int n;
	static int m;
	static StringBuilder sb = new StringBuilder();
	
	// 중복 허용, visit 필요없음
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);
		
		arr = new int[m];
			
		dfs(0,0);
		System.out.println(sb);
	}
	
	public static void dfs(int now, int dep) {
		
		if(dep == m) {
			for(int i = 0; i < arr.length; i++) {
				sb.append(arr[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = now; i < n; i++) {
			arr[dep] = i+1;
			dfs(i,dep+1);
		}
	}
}
