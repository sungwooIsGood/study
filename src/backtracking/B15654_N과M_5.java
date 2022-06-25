package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B15654_N과M_5 {
	
	static int n;
	static int m;
	static int[] arr;
	static boolean[] visit;
	static int[] temp;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
	
		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);
		
		arr = new int[n];
		visit = new boolean[n];
		temp = new int[m];
		
		String[] ss = br.readLine().split(" ");
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(ss[i]);
		}
		
		Arrays.sort(arr);
		
		dfs(0);
		System.out.println(sb);
	}
	
	// 1 7 8 9
	public static void dfs(int dep) {
		if(dep == m) {
			for(int i = 0; i < m; i++) {
				sb.append(temp[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 0; i < n; i++) {
			if(!visit[i]) {
				visit[i] = true;
				temp[dep] = arr[i];
				dfs(dep+1);
				visit[i] = false;
			}
			
		}
	}
}
