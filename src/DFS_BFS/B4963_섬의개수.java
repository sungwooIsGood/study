package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B4963_섬의개수 {

	
	static int w;
	static int h;
	static boolean[][] visit;
	static int[][] graph;
	static int[] dx; 
	static int[] dy; 
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(true) {
			String[] s = br.readLine().split(" ");
			
			// 너비
			w = Integer.parseInt(s[0]);
			
			// 높이
			h = Integer.parseInt(s[1]);
			// land
			graph = new int[h][w];
			visit = new boolean[h][w];
			
			for(int i = 0; i < h; i++) {
				String[] ss = br.readLine().split(" ");
				
				for(int j = 0; j < w; j++) {
					graph[i][j] = Integer.parseInt(ss[j]);
				}
			}
			
			int count = 0; // 섬의 갯수
			
			// 걸어갈수 있는 경로 = 간선이 존재한다.
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					// 간선 조건, land 시 모든 노드 탐색하는 조건문
					if(graph[i][j] == 1 && !visit[i][j]) {
						dfs(i,j);
						// 간선의 갯수만 세라는 뜻
						count++;
					}
				}
			}
			
			System.out.println(count);
		}
		
	}
	
	public static void dfs(int x, int y) {
		
		if(visit[x][y] == true) {
			return;
		} else {
			visit[x][y] = true;
		}
	
		dx = new int[]{0,0,1,-1,-1,1,-1,1};
		dy = new int[]{1,-1,0,0,-1,1,1,-1};
		
		for(int i = 0; i < 8; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			
			// 범위 안에 있어야함
			if(nextX >= 0 && nextX < h && nextY >= 0 && nextY < w) {
				// 조건
				if(graph[nextX][nextY]==1 && !visit[nextX][nextY]) {
					// visit[nextX][nextY] 방문처리 두번해서 틀렸음. return시킬 수 밖에 없었다.
					//visit[nextX][nextY] = true;
					dfs(nextX,nextY);
				}
			}
		}
		
	}

}
