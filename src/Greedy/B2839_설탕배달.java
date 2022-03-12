package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2839_설탕배달 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 모든 경우의 수를 탐색 시 시간을 줄이기 위해 사용
		// a에서 b까지 탐색 시 기준을 가지고 가장 적은 경우의 수부터 탐색하는 것
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int input = Integer.parseInt(br.readLine());
		int temp = 0;
		
		while(true) {
			if(input % 5 == 0) {
				temp += input / 5;
				System.out.println(temp);
				break;
			} else {
				input = input - 3;
				temp++;
			}
			
			if(input < 0) {
				System.out.println(-1);
				break;
			}
		}
		
		
	}
}
