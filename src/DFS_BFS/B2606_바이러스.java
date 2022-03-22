package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class B2606_바이러스 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		// 바이러스 걸린 컴퓨터 갯수
		int count = 0;
		
		// 컴퓨터 갯수
		int com = Integer.parseInt(br.readLine());
		
		// 연결된 선
		int line = Integer.parseInt(br.readLine());
		
		// 노드 저장공간
		ArrayList<Integer>[] list = new ArrayList[com+1];
		
		// 방문 확인 공간
		boolean[] visit = new boolean[com+1];
		
		for(int i = 0; i <= com; i++ ) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < line; i++) {
			String[] ss = br.readLine().split(" ");
			// 쌍방향
			list[Integer.parseInt(ss[0])].add(Integer.parseInt(ss[1]));
			list[Integer.parseInt(ss[1])].add(Integer.parseInt(ss[0]));
		}
		
//		System.out.println(Arrays.toString(list));
		
		Queue<Integer> q = new LinkedList<>();
		
		q.add(1);
		
		// 방문 처리
		visit[1] = true;
		
		while(!q.isEmpty()) {
			
			int node = q.poll();
			
			for (int i = 0; i <  list[node].size(); i++) {
				
				int next = list[node].get(i);
				if(!visit[next]) {
					q.add(next);
					visit[next] = true;
					// 방문할 때마다 count를 올려준다.
					count++;
				}
			}
			
		}
		
		System.out.println(count);
	}

}
