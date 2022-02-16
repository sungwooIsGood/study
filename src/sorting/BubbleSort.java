package algorithm;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		int[] input = {1,3,5,2,9,8,6,0,7,4};
		
		int[] result;
		
		result = bubbleSort(input);
		
		System.out.println(Arrays.toString(result));
	}	
	// 거품정렬 - 서로 인접한 두 원소를 검사하여 가장 큰수를 오른쪽에다 교환하는 방법 
	public static int[] bubbleSort(int[] input){
		// 혼자 알고리즘 방식 구현
		int num = 0;
			
		for(int i = 0; i < input.length; i++) {
		    for(int j = 0; j < input.length; j++) {
		    	if(input.length-1 != j) {
		    		if(input[j] > input[j+1]) {
				    	num = input[j];
				    	input[j] = input[j+1];
				    	input[j+1] = num;
				   	}
		    	} 
		    	continue;
		   	}
		    		
		}
	    return input;
	}
}
		
//	  	다른 사람이 구현한 알고리즘
//	    for(int i = 0; i < arr.length; i++) {
//	        for(int j = 0 ; j < arr.length - i - 1 ; j++) { 
//	    
//	    //======================================================
//	    // arr.length - i를 통해 의미 없이 순환하는 것을 막을 수 있고, -1를 통해 내가 쓴 if문을 줄 일 수 있었다.
//	  	//======================================================
//	    
//		            if(arr[j] > arr[j+1]) {
//	                int temp = arr[j+1];
//	                arr[j+1] = arr[j];
//	                arr[j] = temp;
//	            }
//	        }
//	    }

