package bf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1057_토너먼트 {

	public static void main(String[] args)throws IOException {

		// 김지민 임한수는 무조건 이긴다.
		// 서로 대결하지 않으면 -1
		// 홀수번호면 마지막 번호는 자동 다음 라운드 진출
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		String[] s = br.readLine().split(" ");
		
		int n = Integer.parseInt(s[0]);
		int kim = Integer.parseInt(s[1]);
		int lim = Integer.parseInt(s[2]);
		int count = 0;
		
		// 1씩 더해준 이유 홀수 일 가능성이 있기 때문에
		while(kim != lim) {
			kim = (kim + 1) / 2;
			lim = (lim + 1) / 2;
			count++;
		}
		System.out.println(count);
	
	
	
	}

}
