package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class B11047_동전0 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s  = br.readLine().split(" ");
		
		// 동전 종류
		int x = Integer.parseInt(s[0]);
		
		// 동전의 합
		int y = Integer.parseInt(s[1]);
		
		// 내림차순은 Integer로 해야함
		Integer[] arr = new Integer[x];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
        Arrays.sort(arr,Collections.reverseOrder());
		// 동전갯수 최소값
		int count = 0;
		
		for(int i = 0; i < arr.length; i++) {
			
			if(arr[i] < 4200) {
				count += y / arr[i];
				y = y % arr[i] ; // 4200 / 1000  y == 200
			}
		}
		System.out.println(count);
	}

}
