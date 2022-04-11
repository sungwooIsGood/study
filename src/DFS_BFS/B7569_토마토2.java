package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B7569_토마토2 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		// 가로
		int m = Integer.parseInt(s[1]);
		// 세로
		int n = Integer.parseInt(s[0]);
		// 높이
		int h = Integer.parseInt(s[2]);
		
		// 3차원 배열은 높이,행,열 순
		int[][][] graph = new int[h][m][n];
		boolean[][][] visit = new boolean[h][m][n];
		
		// 초기화
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < m; j++) {
				String[] ss = br.readLine().split(" ");
				for(int k = 0; k < n; k++) {
					graph[i][j][k] = Integer.parseInt(ss[k]);
				}
			}
		}
		
		Queue<int[]> q = new LinkedList<>();

		for(int i = 0; i < h; i++) {
			
			for(int j = 0; j < m; j++) {
				
				for(int k = 0; k < n; k++) {
					if(graph[i][j][k] == 1) {
						
						q.add(new int[] {i,j,k});
					
					}
				}
			}
		}
		
		// 최소 거리 찾기
		int count = 0;
		
		int[] dx = {0,0,0,1,0,-1};
		int[] dy = {0,0,1,0,-1,0};
		int[] dh = {1,-1,0,0,0,0};
		
		while(!q.isEmpty()) {
			
			int[] node = q.poll();
			
			int z = node[0];
			int x = node[1];
			int y = node[2];
			
			for(int i = 0; i < 6; i++) {
				int nextX = x + dx[i];
				int nextY = y + dy[i];
				int nextZ = z + dh[i];
				
				if(nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && nextZ >= 0 && nextZ < h) {
					if(graph[nextZ][nextX][nextY] == 0 && !visit[nextZ][nextX][nextY]) {
						q.add(new int[] {nextZ, nextX, nextY});
						visit[nextZ][nextX][nextY] = true;
						graph[nextZ][nextX][nextY] = graph[z][x][y] + 1;
					}
				}
			}
			
		}

		// 안익은곳 체크
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < m; j++) {
				for(int k = 0; k < n; k++) {
					
					if(graph[i][j][k] == 0) {
						System.out.println(-1);
						return;
					} else {
						if(count < graph[i][j][k]) {
							count = graph[i][j][k];
						}
					}
				}
			}
		}
		System.out.println(count-1);
		
		// 1부터 시작하기 때문에 -1을 해준다.
	}

}
