package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
		
		arr = new ArrayList[m]; // 정점 기준? 간선 기준?
		visit = new boolean[m];
		
		for(int i = 0; i < arr.length; i++) {
			// arrayList를 담으려면 선언을 해준 후 담아주어야한다.
			arr[i] = new ArrayList<>();
			String[] ss = br.readLine().split(" ");
			
			arr[i].add(Integer.parseInt(ss[0]));
			arr[i].add(Integer.parseInt(ss[1]));
		}
		
		
		q = new LinkedList<>();
		
//		dfs(v);
		
		for(int i = 0; i < visit.length; i++) {
			visit[i] = false;
		}
		
		bfs(v);
		
	}
	
	public static void dfs(int n) {
		
		// 방문 했으면 재귀를 종료
		if(visit[n] == true) {
			return;
		} else {
			visit[n] = true;
		}
		
		for(int i = 0; i < arr[n].size(); i++) {
			dfs(arr[n].get(i));
		}
		
	}
	
	public static void bfs(int n) {
		// queue에 삽입
		q.offer(n);
		
		// 방문처리
		visit[n] = true;
		
		// 꺼낸 노드에 인접한 방문하지 않은 노드를 방문하고 큐에 삽입
		while(!q.isEmpty()) {
			// queue에 있는 값을 꺼낸다.
			int current = q.poll(); // 1,3,2,4
			
			
			for(int i = 0; i < arr[current].size(); i++) {
				int next = arr[current].get(i);
				
				if(!visit[next]) {
					q.offer(next);
					visit[next] = true;
				}
				System.out.println(n);
			}
		}
	}

}
