package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B7576_토마토 {

	static Queue<int[]> q = new LinkedList<>();
	static boolean[][] visit; 
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		// 가로
		int m = Integer.parseInt(s[1]);
		
		// 세로
		int n = Integer.parseInt(s[0]);
		
		int[][] graph = new int[m][n];
		
		visit = new boolean[m][n];
		
		for(int i = 0; i < m; i++) {
			String[] ss = br.readLine().split(" ");
			
			for(int j = 0; j < n; j++) {
				graph[i][j] = Integer.parseInt(ss[j]);
				
				// 익은 사과 찾기
				if(graph[i][j] == 1) {
					// 1인 곳에서 시작 / 복수 가능
					q.add(new int[] {i,j});
					visit[i][j] = true;
				}
			}
		}
		
		System.out.println(bfs(m,n,graph));
	}
	
	public static int bfs(int m, int n, int[][] graph) {
		
		
		// 최소거리찾기
		int min = 0;
		
		// 위, 오, 아래,왼
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		
		while(!q.isEmpty()) {
			
			int[] node = q.poll();
			
			// 현재좌표
			int x = node[0];
			int y = node[1];
			
			for(int i = 0; i < 4; i++) {
				int nextX = x + dx[i];
				int nextY = y + dy[i];
				
				if(nextX >= 0 && nextX < m && nextY >=0 && nextY < n) {
					
					if(graph[nextX][nextY] == 0 && !visit[nextX][nextY]) {
						visit[nextX][nextY] = true;
						graph[nextX][nextY] = graph[x][y] + 1;
						q.add(new int[] {nextX,nextY});
					}
				}
			}
		}
		
		// 0이 남아있는지 확인
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(min < graph[i][j]) {
					min = graph[i][j];
				}
				
				if(graph[i][j] == 0) {
					return -1;
				}
			}
		}
		
		return min - 1;
		
	}

}
