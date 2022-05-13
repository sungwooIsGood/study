package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B1743_음식물피하기 {

	static int n;
	static int m;
	static int min; // 탐색한 곳을 넣는 공간
	static int count; // 탐색할때마다 하나씩 올려준다.
	
	static int[][] graph;
	static boolean[][] visit;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 뭉쳐있는 음식물 쓰레기 갯수 세기
		// 뭉쳐있는 것들 중의 가장 많이 뭉쳐있는거 반환
		String[] s = br.readLine().split(" ");
		
		// 세로
		n = Integer.parseInt(s[0]);
		// 가로
		m = Integer.parseInt(s[1]);
		// 음식물 쓰레기 갯수
		int k = Integer.parseInt(s[2]);
		
		min = 0;

		graph = new int[n+1][m+1];
		visit = new boolean[n+1][m+1];
		
		for(int i = 0; i < k; i++) {
			String[] ss = br.readLine().split(" ");
			graph[Integer.parseInt(ss[0])][Integer.parseInt(ss[1])] = 1;
		}
		
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				if(!visit[i][j] && graph[i][j] == 1) {
					
					visit[i][j] = true;
					bfs(i,j);
					if(min < count) {
						min = count;
					}
//					System.out.println(count);
				}
			}
		}
		System.out.println(min);
		
	}
	
	public static void bfs(int a, int b) {
		
		// bfs 메소드가 실행 됐다는 것은 하나라도 있다는 의미
		count = 1;
		
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {a,b});
		
		while(!q.isEmpty()) {
			
			int[] node = q.poll();
			
			int x = node[0];
			int y = node[1];
			
			for(int i = 0; i < 4; i++) {
				
				int nextX = x + dx[i];
				int nextY = y + dy[i];
				// 좌표값 조건(가로,세로 최대크기보다 작고 (1,1)에서 시작했으니 (1,1)보다 커야한다)
				if(nextX < n+1 && nextX > 0 && nextY < m+1 && nextY > 0) {
					// 탐색 조건
					if(!visit[nextX][nextY] && graph[nextX][nextY] == 1) {
						q.add(new int[] {nextX,nextY});
						visit[nextX][nextY] = true;
						count++;
					}
				}
			}
		}

	}

}
