package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B10026_적록색약 {

	static int n;
	static char[][] graph;
	static boolean[][] visit;
	// 적록색약인 사람
	static int non;
	// 평범한 사람
	static int nomal;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		graph = new char[n+1][n+1];
		visit = new boolean[n+1][n+1];
		
		nomal = 0;
		non = 0;

		for(int i = 1; i <= n; i++) {
			String s = br.readLine();
			for(int j = 1; j <= n; j++) {
				graph[i][j] = s.charAt(j-1);
			}
		}
		// 정상인 : 현재 알파벳과 다음 알파벳이 같아야 한다.
		// 적록색약 : R과 G는 같은 알파벳으로 본다.
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				// 정상인 탐색 조건
				if(!visit[i][j]) {
					dfs(i,j);
					nomal++;
				}
				
			}
		}
		// 적록색약 - G를 R로 바꾸어 준다.
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(graph[i][j] == 'G') {
					graph[i][j] = 'R';
				}
			}
		}
		// visit을 다시 재할당 해준다.
		visit = new boolean[n+1][n+1];
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(!visit[i][j]) {
					dfs(i,j);
					non++;
				}
			}
		}
		System.out.println(nomal + " " + non);
	}
	
	public static void dfs(int x, int y) {
		
		// 재귀 함수 방문처리
		if(visit[x][y] == true) {
			return;
		} else {
			visit[x][y] = true;
		}
		
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,-1,1};
		
		for(int i = 0; i < 4; i++) {
			int nextX = dx[i] + x;
			int nextY = dy[i] + y;
			
			// 범위 조건 설정
			if(nextX < n+1 && nextX > 0 && nextY < n+1 && nextY > 0) {
				// 조건 설정
				if(graph[x][y] == graph[nextX][nextY] && !visit[nextX][nextY]) {
					dfs(nextX, nextY);
				}
			}
		}
	}
	


}
