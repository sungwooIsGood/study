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
		int[] arr = new int[x];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		// 내림차순 정렬
        Arrays.sort(arr);
		
        // 동전갯수 최소값
		int count = 0;
		
		for(int i = arr.length-1; i >= 0; i--) {
			
			if(arr[i] <= y) {
				count += y / arr[i];
				y = y % arr[i] ; 
			}
		}
		System.out.println(count);
	}

}
