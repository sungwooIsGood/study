package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B9466_텀프로젝트 {

	static int[] graph;
	static boolean[] visit;
	static boolean[] tum; // 시작 = 끝 이 같을 때 true;
	static int count;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < test; i++) {
			
			int person = Integer.parseInt(br.readLine());
			
			graph = new int[person+1];
			visit = new boolean[person+1];
			tum = new boolean[person+1];
			
			count = 0;

			String[] ss = br.readLine().split(" ");
			
			for(int j = 1; j < person+1; j++) {
				graph[j] = Integer.parseInt(ss[j-1]);
			}
			
			// 1 -> 2 -> 3 -> 1 이면 한 팀 / 1 -> 1 이어도 한팀 
			// 마지막이 가르키는 게 r-1이면 visit해야한다.
			for(int j = 1; j < person+1; j++) {
				dfs(j);
			}
			
//			System.out.println(Arrays.toString(tum));
			System.out.println(person - count);
		}
	}
	
	public static void dfs(int node) {

		int nextNode = graph[node]; // 7 = 4

		if(visit[node] == true) {
			
			if(!tum[nextNode]) {
				count++;
				while(nextNode != node) {
					count++;
					nextNode = graph[nextNode];
				}
			} 
			tum[node] = true;
			return;
		} else {
			visit[node]= true; // 시작과 끝이 같을 때 true 반환
		}
		
		// 방문을 했었다.
		
		dfs(nextNode);
	}

}
