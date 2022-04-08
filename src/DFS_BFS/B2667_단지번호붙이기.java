package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 메모리 14228 더 줄여보기.
public class B2667_단지번호붙이기 {

	static int[][] graph;
	static boolean[][] visit;
	static int n;
	// 오름차순을 위한 배열
	static int[] sort;
	static int cnt;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 정사각형 크기
		n = Integer.parseInt(br.readLine());
		
		graph = new int[n+1][n+1];
		visit = new boolean[n+1][n+1];
		// 정사각형 최대 25 * 25
		// ArrayList로 해도 되었다.
		sort = new int[625]; 
		for(int i = 1; i < n+1; i++) {
			String s = br.readLine();
			
			for(int j = 1; j < n+1; j++) {
				graph[i][j] = s.charAt(j-1) -'0';
			}
		}
		
		// 단지 수
		int count = 0;
		
		for(int i = 1; i <n+1; i++ ) {
			for(int j = 1; j < n+1; j++) {
				if(graph[i][j] == 1 && !visit[i][j]) {
					dfs(i,j);
					sort[count] = cnt-1;
					count++;
				}
			}
		}
		// 단지 수 출력
		System.out.println(count);
		Arrays.sort(sort);

		// 가구 수 출력
		for(int i = sort.length-count; i < sort.length; i++) {
			System.out.println(sort[i]);
		}
		
		// 가구 수 카운트 확인용
//		for(int i = 1; i <n+1; i++ ) {
//			System.out.println();
//			for(int j = 1; j < n+1; j++) {
//				System.out.print(graph[i][j]);
//			}
//		}

	}
	
	public static void dfs(int x, int y) {
		
		if(visit[x][y] == true) {
			return;
		} else {
			visit[x][y] = true;
		}
		
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,1,-1};
		
		// 단지 내 가구 수
		cnt = graph[x][y]+1;

		for(int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			if(nextX >= 0 && nextX < n+1 && nextY >= 0 && nextY < n+1) {
				if(graph[nextX][nextY] ==1 && !visit[nextX][nextY]) {
					graph[nextX][nextY] = cnt;
					dfs(nextX,nextY);
				}
			}

		}
	}

}
