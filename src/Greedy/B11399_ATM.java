package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B11399_ATM {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// atm 기다리는 사람
		int num = Integer.parseInt(br.readLine());
		// 각각의 사람들이 걸리는 시간
		int[] arr = new int[num];
		
		String[] s = br.readLine().split(" ");
	
		for(int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(s[i]);
		}
		
		Arrays.sort(arr);
		
		int temp = 0;
		int result = 0;
		
		for(int i = 0; i < arr.length; i++) {
			temp += arr[i];
			result += temp;
		}
		System.out.println(result);
	}

}
