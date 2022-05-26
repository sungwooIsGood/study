package Im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1138_한줄로서기 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		
		// 왼쪽의 자기보다 큰 사람을 기억하는 배열
		int[] arr = new int[num];
		boolean[] visit = new boolean[num];
		
		String[] s = br.readLine().split(" ");

		for(int i = 0 ; i < num; i++) {
			int n = Integer.parseInt(s[i]);
			
			// 포인터 역할
			int pointer = 0;
			
			for(int j = 0; j < num; j++) {
				
				if(!visit[j]) {
					if(pointer == n) {
						visit[j] = true;
						arr[j] = i+1;
						break;
					} else {
						pointer++;
					}
				} 
			}
			
		}
		
		for(int i = 0; i < num; i++) {
			System.out.print(arr[i] + " ");
		}
		
	}

}
