package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B15650_N과M_2 {
	
	static int n;
	static int m;
	static int[] arr;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		String[] s = br.readLine().split(" ");
		
		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);
		
		arr = new int[m];
		visit = new boolean[n];
		
		dfs(0,0);
		
	}
	
	public static void dfs(int now, int dep) { 
		
		if(dep == m) {
			for(int i = 0; i < m; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = now; i< n; i++) {
			if(!visit[i]) {
				visit[i] = true;
				arr[dep] = i+1; 
				dfs(i+1, dep+1);
				visit[i] = false;
			}
		
		}
			
			
	}
	
	
}
