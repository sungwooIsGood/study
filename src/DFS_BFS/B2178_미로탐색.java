package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class B2178_미로탐색 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		
		int[][] graph = new int[n][m];
		
		// charAt()- '0' 은 char형으로 안바뀌고 int형으로 읽게된다.
		for(int i = 0; i < n; i++) {
			String ss = br.readLine();
			for(int j = 0; j < m; j++) {
				graph[i][j] = ss.charAt(j)-'0';
//				System.out.print(graph[i][j]);
			}
//			System.out.println(); 
		}
		System.out.print(bfs(n, m, graph));
		
	}
	
	public static int bfs(int n, int m, int[][] graph) {
		
		//좌표 - 상,하,좌,우
		int[] dx = {1,-1,0,0}; 
		int[] dy = {0,0,-1,1};
		
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visit = new boolean[n][m];
		
		// (0,0)부터 검사
		// 타입을 맞추기 위한 초기화, Queue<int[]> = new int{0,0}이라고 생각하면 좋다
		q.add(new int[]{0, 0});
		visit[0][0] = true;
		
		while(!q.isEmpty()) {
			
			int[] node = q.poll();
			
			// 현재 좌표
			int x = node[0];
			int y = node[1];
			
			// 4인 이유는 상,하,좌,우 값임
			for(int i = 0; i < 4; i++) {
				int nextX = node[0] + dx[i]; // ex) 오른쪽 +1 ...
				int nextY = node[1] + dy[i]; // ex) 아래 +1 ...
				
				// 0이거나 방문했던 곳이면 건너 뛰기
				if(nextX >= 0 && nextX < n && nextY >=0 && nextY < m) {
					
					if(graph[nextX][nextY] == 1 && !visit[nextX][nextY]) {
						
						visit[nextX][nextY] = true;
						graph[nextX][nextY] = graph[x][y] + 1; // count 역할
						System.out.println(graph[nextX][nextY]);
						q.add(new int[] {nextX,nextY});
					}
				
				}
				
				
			}
			
		}
//		ex) 인덱스 번호로는 [3][5]가 맥스 거리기 때문에
		return graph[n-1][m-1];
	}

}
