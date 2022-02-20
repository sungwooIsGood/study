package recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 하노이의 탑
public class B11729 {
	
	static int count;
	static StringBuilder s;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine()); // 원판 갯수
		count = 0;
		s = new StringBuilder();
		
		hanoi(num,1,2,3); // (원판 갯수, 장대1, 장대2, 장대3)
		System.out.println(count);
		System.out.println(s);
	}
	
	static void hanoi(int num,int start,int mid, int end) { 
		count++;
		if(num == 1) {
			s.append(start + " " + end + "\n");
			return;
		} else {
			// 1. num-1개를 start에서 mid로이동
			hanoi(num-1,start,end,mid);
			// 2. 1개를 start에서 end로이동
			 s.append(start + " " + end + "\n");
			// 3. num-1개를 mid에서 start로이동.
			hanoi(num-1,mid,start,end);
		}
	}
	
}
