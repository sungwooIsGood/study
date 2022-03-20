package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B16953 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		Long a = Long.parseLong(s[0]);
		Long b = Long.parseLong(s[1]);
		
		int count = 1;
	
		// 숫자를 단위수로 자르려면 num / 10 을 하면 된다. ex) 40021 / 10 = 4002
		while(true) {
			
			if(b % 2 != 0) {
				b = b / 10;
				count++;
			} else if(b % 2 == 0){
				b = b / 2;
				count++;
			} 
			if(b == a){
				break;
			} else if (b < a) {
				count = -1;
				break;
			}
		}
		System.out.println(count);
		
	}

}
