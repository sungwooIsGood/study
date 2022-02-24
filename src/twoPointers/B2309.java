package twoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2309 {

	// 일곱난쟁이 문제	
	// 7개의 합을 구하는 것이지만 9개 중 두 수의 합을 빼면 되는 것 (100 - (s+e)) 를 구해서 빼준다.
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[9];
		
		// 배열 채우기
		for(int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		int s = 0;
		int e = arr.length-1;
		// 배열의 총합계 구하기
		int total = 0;
		for (int i = 0; i < arr.length; i++) {
            total+=arr[i]; 
        }
		while(s < e) {
			
			if(arr[s] + arr[e] == total - 100) {
				
				for(int i = 0; i < arr.length; i++) {
					if(i == s || i == e) {
						continue;
					} else {
						System.out.println(arr[i]);
					}
		
				}
				
				break;
				
			} else if(arr[s] + arr[e] < total - 100) {
				s++;
			} else {
				e--;
			}
		}
	}

}
