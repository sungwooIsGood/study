package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class B1697_숨바꼭질 {

	static int[] graph;
	static boolean[] visit;
	static int time;
	static Queue<int[]> q = new LinkedList<>();
	static int n;
	static int k;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 걸을 때 x+1, x-1 // 순간이도 2 * x
		String[] s = br.readLine().split(" ");
		// 수빈이
		n = Integer.parseInt(s[0]);
		// 동생
		k = Integer.parseInt(s[1]);
		
		graph = new int[100001];
		visit = new boolean[100001];
		
		q.add(new int[] {n});
		visit[n] = true;
		bfs();
//		System.out.println(time);
	}
	// 100 0 안됨.
	public static void bfs() {
		
		int[] dx = {1,-1,2};
		
		while(!q.isEmpty()) {
			int[] node = q.poll();
			
			int x = node[0];
			
			for(int i = 0; i <= 2; i++) {
				int nextX = 0;
				if(i == 2) {
					nextX = x * dx[i];
				} else {
					nextX = x + dx[i];
				}
				
				if(nextX >= 0 && nextX < graph.length) {
					if(graph[nextX] == 0 && !visit[nextX]) {
//						System.out.println(x);
						if(x == k) {
							time = graph[k];
							System.out.println(time);
							return;
						} else {
							graph[nextX] = graph[x]+1;
//							System.out.println(Arrays.toString(graph));
							visit[nextX] = true;
							q.add(new int[] {nextX});
						}
					}
					
				}
			}
			
		}
		
		
	} 

}
