package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class B1260_DFS와BFS {

	static int n;
	static int m;
	static int v;
	
	static ArrayList<Integer>[] arr;
	static boolean visit[];
	
	static Queue<Integer> q;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		// 정점
		n = Integer.parseInt(s[0]);
		// 간선
		m = Integer.parseInt(s[1]);
		// 정점의 번호
		v = Integer.parseInt(s[2]);
		
		arr = new ArrayList[n+1]; // index가 0이아닌 1로 시작해주기 위해서 안헷갈리기 위한것.
		visit = new boolean[n+1];
		
		boolean[][] arr1 = new boolean[n+1][n+1];
		
		// 연결된 노드 정보
		// arr[1] = [2,3,4] / arr[2] = [1,4] / arr[3] =[1,4] / arr[4] = [1,2,3,4]
		for(int i = 0; i < arr.length; i++) {
			arr[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < m; i++) {
			// arrayList를 담으려면 선언을 해준 후 담아주어야한다.
			String[] ss = br.readLine().split(" ");
			// arr1노드 안에 서로 연결되어있으면 true로 만들어 주는 
			arr[Integer.parseInt(ss[0])].add(Integer.parseInt(ss[1]));
			arr[Integer.parseInt(ss[1])].add(Integer.parseInt(ss[0]));
		}
		
//		정렬시키기 '방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문'
		for(int i = 0; i < arr.length; i++) {
			Collections.sort(arr[i]);
		}
		
		
		dfs(v);
		System.out.println();
		
		// bfs를 위해 false 처리 
		visit = new boolean[n+1];
		
		
		bfs(v);
		
	}
	
	public static void dfs(int n) { 
		
		// 방문 했으면 재귀를 종료
		if(visit[n] == true) {
			return;
		} else {
			visit[n] = true;
		}
		
		System.out.print(n + " ");
		for(int i = 0; i < arr[n].size(); i++) {
			dfs(arr[n].get(i));
		}
		
	}
	
	public static void bfs(int n) {
		
		q = new LinkedList<>();
		// queue에 삽입
		q.add(n);
		// 트리 맨 위에 있는 첫번째 노드 방문처리
		visit[n] = true;
		
		// queue안이 빌때까지 즉, 트리에 있는 모든 노드를 너비만큼 돌았을 경우 종료
		while(!q.isEmpty()) {
			// queue에 있는 노드를 하나씩 가로로 탐색
			int node = q.poll();
			
			for(int i = 0; i < arr[node].size(); i++) {
				// arr(노드)안에 있는 배열값들을 하나씩 다 탐색
				int next = arr[node].get(i);
				
				if(!visit[next]) {
					q.add(next);
					visit[next] = true;
				}
			}
			System.out.print(node + " ");
		}
			
	}

}
