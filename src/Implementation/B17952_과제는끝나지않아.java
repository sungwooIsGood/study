package Im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B17952_과제는끝나지않아 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		Stack<Integer> work = new Stack<>();
		Stack<Integer> time = new Stack<>();
		
		// 과제 총합점
		int result = 0;
		
		for(int i = 0; i < n; i++) {
			String[] s = br.readLine().split(" ");
			
			if(Integer.parseInt(s[0]) > 0) {
				
				work.push(Integer.parseInt(s[1])); // 10, 100, 20
				time.push(Integer.parseInt(s[2])-1); // 2, 1, 0
				
			} else {
				if(!work.isEmpty() && !time.isEmpty()) {
					time.push(time.pop()-1); // 10, 1 => 100, 0
				}
			}
//			System.out.println(time);
			
			if(!work.isEmpty() && !time.isEmpty() && time.peek() <= 0) {
				time.pop();
				result += work.pop();
			}
		}

		System.out.println(result);
	}

}
