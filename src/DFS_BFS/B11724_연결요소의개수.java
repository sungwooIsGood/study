package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class B11724_연결요소의개수 {

	public static void main(String[] args) throws IOException {
		
		// 무방향 그래프는 곧 양방향 그래프 라는 것, 이 말은 양방향 그래프라는 말임. 서로서로 이동가능함.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		String[] s = br.readLine().split(" ");
		
		// 정점의 개수
		int n = Integer.parseInt(s[0]);
		
		// 간선의 개수
		int m = Integer.parseInt(s[1]);
		
		ArrayList<Integer>[] list = new ArrayList[n+1];
		boolean[] visit = new boolean[n+1];
		
		for(int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < m; i++) {
			String[] ss = br.readLine().split(" ");
			list[Integer.parseInt(ss[0])].add(Integer.parseInt(ss[1]));
			list[Integer.parseInt(ss[1])].add(Integer.parseInt(ss[0]));
		}

//		System.out.println(Arrays.toString(list));
		
		int count = 0;
		
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 1; i < visit.length; i++) {
			
//			System.out.println(Arrays.toString(visit));
			if(visit[i] == false) {
				
				q.add(i);
				
				visit[i] = true;
						
				while(!q.isEmpty()) {
					
					int node = q.poll();
					
					for(int j = 0; j < list[node].size(); j++) {
						int next = list[node].get(j);
						
						if(!visit[next]) {
							q.add(next);
							visit[next] = true;
						} 
					}
				}
				count++;
			}
		}
		
		System.out.println(count);
	}

}
