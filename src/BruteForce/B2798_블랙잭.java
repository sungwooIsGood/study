package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2798_블랙잭 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 카드 개수
		String[] f = br.readLine().split(" ");
		
		int count = Integer.parseInt(f[0]);
		// 최대값
		int result = Integer.parseInt(f[1]);
		
		int[] arr = new int[count];
		
		// 배열 채우기
		String[] s = br.readLine().split(" ");

		for(int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(s[i]);
		}
		Arrays.sort(arr);
		// 카드가 가르키는 것
		int i = 0;
		int j = 1;
		int k = 2;
		int temp = 0;
		
		for(i = 0; i < j; i++) {
			for(j = i+1; j < k; j++) {
				for(k = j+1; k < arr.length; k++) {
					if(temp <= arr[i]+arr[j]+arr[k] && arr[i]+arr[j]+arr[k] <= result) {
						temp = arr[i]+arr[j]+arr[k];
						
					} 
				}
			}
		}
		System.out.println(temp);
	}

}
