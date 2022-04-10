package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class B2468_안전영역 {

	static int n;
	static int[][] graph;
	static boolean[][] visit;
	static int count;
	static int maxCount;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		//  행과 열의 크기가 각각 N인 2차원 배열 형태 - 정사각형
		n = Integer.parseInt(br.readLine());
		
		graph = new int[n][n];
		visit = new boolean[n][n];
		
		// 장마철에도 살아남는 땅
		count = 0;
		maxCount = 0;
		
		for(int i = 0; i < n; i++) {
			
			String[] s = br.readLine().split(" ");
			
			for(int j = 0; j < n; j++) {
				graph[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(graph[i][j] > n && !visit[i][j]) {
					maxCount = Math.min(count, maxCount);
//					System.out.println(maxCount);
					maxCount++;
					dfs(i,j);
				}
			}
		}
//		for(int i = 0; i < n; i++) {
//			System.out.println();
//			for(int j = 0; j < n; j++) {
//				System.out.print(" " + graph[i][j]);
//			}
//		}
//		System.out.println();
		System.out.println(maxCount);
		

	}
	
	static void dfs(int x, int y) {


		if(visit[x][y] == true) {
			return;
		} else {
			visit[x][y] = true;
			if(graph[x][y] >= n) {
				count++;
				graph[x][y] = count;
			}
		}
		
		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};
		
		for(int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			
			if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < n ) {
				if(graph[nextX][nextY] > n && !visit[nextX][nextY]) {
					dfs(nextX,nextY);
				}
				
			}
		}
	}
	
}
