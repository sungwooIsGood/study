package dataStructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class B10845_큐 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		Queue<Integer> queue = new LinkedList<>();
		
		int num = Integer.parseInt(br.readLine());
		
		int input = 0;
		
		for(int i = 0; i < num; i++) {
			
			String n = br.readLine();
			
			if(n.contains("push")) {
				String[] s = n.split(" ");
				input = Integer.parseInt(s[1]);
				
				queue.offer(input);
			}
			
			if(n.contains("pop")) {
				if(!queue.isEmpty()) {
//					bw.write(queue.poll() + "\n");
					sb.append(queue.poll() + "\n");
				} else {
//					bw.write(-1 + "\n");
					sb.append(-1 + "\n");
				}
			}
			
			if(n.contains("size")) {
//				bw.write(queue.size() + "\n");
				sb.append(queue.size() + "\n");
			}
			
			if(n.contains("empty")) {
				if(!queue.isEmpty()) {
//					bw.write(0 + "\n");
					sb.append(0 + "\n");
				} else {
//					bw.write(1 + "\n");
					sb.append(1 + "\n");
				}
			}
			
			if(n.contains("front")) {
				if(!queue.isEmpty()) {
//					bw.write(queue.peek() + "\n");
					sb.append(queue.peek() + "\n");
				} else {
//					bw.write(-1 + "\n");
					sb.append(-1 + "\n");
				}
			}
			
			if(n.contains("back")) {
				if(!queue.isEmpty()) {
//					bw.write(input + "\n");
					sb.append(input + "\n");
				} else {
//					bw.write(-1 + "\n");
					sb.append(-1 + "\n");
				}
			}
		}
		System.out.println(sb);
		// close를 안해주면 sysout이 작동이 안된다.
//		bw.flush();
//		bw.close();
		br.close();
	}

}
