package bf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1436_영화감독숌 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 6이 적어도 3개 이상 들어가는 연속된 수
		int n = Integer.parseInt(br.readLine());
		
		int count = 0;
		int temp = 0;
		int i = 1;
		
		String s = "";
		
		while(true){
			
			s = String.valueOf(i);
			
			if(s.contains("666")) {
				count++;
				if(n == count) {
					break;
				}
			}
			
			i++;
			
		}
		
		System.out.println(s);
	}

}
