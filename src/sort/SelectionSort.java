package sort;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		int[] input = {1,3,5,2,9,8,6,0,7,4};
		
		int[] result;
		result = selectionSort(input);
		
		System.out.println(Arrays.toString(result));
	}
	
	// 선택정렬 - 배열안에서 최솟값을 찾고, 최솟값을 맨 앞 자리의 값과 교환하며 맨 앞자리를 제외한 나머지 값들 중 최솟값을 찾는 방법
		public static int[] selectionSort(int[] input){
			
			int min = 0;
			
			for(int i = 0; i < input.length; i++) {
				for(int j = i+1; j < input.length; j++) {
					if(input[i] > input[j]) {
						min = input[i];
						input[i] = input[j];
						input[j] = min;
					}
				}
			}
			
		    return input;
		}

}
