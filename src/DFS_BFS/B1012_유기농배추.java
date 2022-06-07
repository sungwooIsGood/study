package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B1012_유기농배추 {

	static int m;
	static int n;
	
	static int[][] graph;
	static boolean[][] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test = Integer.parseInt(br.readLine());
		
		for(int c = 0; c < test; c++) {
			
			String[] s = br.readLine().split(" ");
			
			m = Integer.parseInt(s[0]);
			n = Integer.parseInt(s[1]);
			int k = Integer.parseInt(s[2]);
			
			int count = 0;
			
			graph = new int[m][n];
			visit = new boolean[m][n];
			
			for(int i = 0; i < k; i++) {
				
				String[] ss = br.readLine().split(" ");
				
				int x = Integer.parseInt(ss[0]);
				int y = Integer.parseInt(ss[1]);
				graph[x][y] = 1;
				
			}
			
			for(int i = 0; i < m; i++) {
				for(int j = 0; j < n; j++) {
					if(!visit[i][j] && graph[i][j] == 1) {
						bfs(i,j);
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}
	
	public static void bfs(int x, int y) {
		
		Queue<int[]> q = new LinkedList<>();
		
		q.add(new int[] {x,y});
		// 위, 오, 아래,왼
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};	
		
		while(!q.isEmpty()) {
			int[] node = q.poll();
			
			int nowX = node[0];
			int nowY = node[1];
			
			for(int i = 0 ; i < 4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				
				if(nextX < m && nextX >= 0 && nextY < n && nextY >=0) {
					if(!visit[nextX][nextY] && graph[nextX][nextY] == 1) {
						q.add(new int[] {nextX, nextY});
						visit[nextX][nextY] = true;
					}
				}
			}
		}
		
		
	}

}
