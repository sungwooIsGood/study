package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B7562_나이트의이동 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < test; i++) {
			
			// 체스 한변의 길이
			int n = Integer.parseInt(br.readLine());
			
			int[][] graph = new int[n][n];
			boolean[][] visit = new boolean[n][n];
			
			// 시작점
			String[] s = br.readLine().split(" ");
			graph[Integer.parseInt(s[0])][Integer.parseInt(s[1])] = 0;
			
			// 종료지점
			String[] ss = br.readLine().split(" ");
			
			int endX = Integer.parseInt(ss[0]);
			int endY = Integer.parseInt(ss[1]);
			
			Queue<int[]> q = new LinkedList<>();
			
			// 현재 위치
			q.add(new int[] {Integer.parseInt(s[0]),Integer.parseInt(s[1])});
			visit[Integer.parseInt(s[0])][Integer.parseInt(s[1])] = true;
			
			int dx[] = { -1, -2, -2, -1, 1, 2, 2, 1 };
			int dy[] = { -2, -1, 1, 2, 2, 1, -1, -2 };

			
			while(!q.isEmpty()) {

				int[] node = q.poll();
				
				int x = node[0];
				int y = node[1];

				if(x == endX && y == endY) {
					System.out.println(graph[endX][endY]);
					break;
				} else {
					for(int j = 0; j < 8; j++) {
						int nextX = x + dx[j];
						int nextY = y + dy[j];
						
						if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < n) {
							if(!visit[nextX][nextY]) {
								q.add(new int[] {nextX,nextY});
								graph[nextX][nextY] = graph[x][y] + 1;
								visit[nextX][nextY] = true;
							}
						}
					}
				}
				
			}
		}
	}

}
