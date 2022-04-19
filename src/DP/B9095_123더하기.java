package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B9095_123더하기 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 점화식 
		// 0 = 0
		// 1 = 1+0 (1)
		// 2 = 1+1,2 (2)
		// 3 = 1+1+1,1+2,2+1,3 (4)
		// 4 = 1+1+1+1,1+1+2,1+2+1,2+1+1 // 2+2 // 3+1,1+3 (7)

		int test = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < test; i++) {
			
			int n = Integer.parseInt(br.readLine());
			
			ArrayList<Integer> result = new ArrayList<>();
			
			// 1~3의 경우의 수를넣은 것
			result.add(1);
			result.add(2);
			result.add(4);
			
			for(int j = 3; j < n; j++) {
				result.add(result.get(j-3) + result.get(j-2) + result.get(j-1));
			}
			System.out.println(result.get(n-1));
		}		
	}

}
