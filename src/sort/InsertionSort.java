package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class InsertionSort {
	
	// 삽입정렬: 2번째 인덱스 부터 key값을 가지며, key값의 이전 값들(정렬된 배열)과 비교하여 key값을 정렬된 배열 사이안에 삽입하는 정렬
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 뒤에 인덱스(key)와 배열을 비교. 인덱스 0과 1비교 0,1과 2비교 0,1,2와 3비교
	      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	      
	      int[] arr = new int[Integer.parseInt(br.readLine())];
	      
	      int pre = 0; // 1
	      
	      // 배열 채우기
	      for(int i = 0; i < arr.length; i++) {
	         arr[i] = Integer.parseInt(br.readLine());
	      }
	      
	      // 예시 입력값 [3, 2, 1]
	      for(int i = 1; i < arr.length; i++) {
	         
	    	 int key = arr[i]; // key값 3
	    	
	    	 //int[] pre = new int[i];// key값 비교할 이전 인덱스 2
	    	  
	    	  
	    	  for(int j = pre; j >= 0; j--) { // 2
	    		  
	    		  if(arr[j] > key) { // arr[0](3) > 2                                 /  j=1 arr[1](3) > arr[2](1)               / j=0 arr[0](2) > key(arr[2] 1)                                              
	    			  arr[j+1] = arr[j]; // arr[1] = arr[0]      => arr[0] = 3 , 3-3-1  /  arr[2](1) = arr[1](3) => 2-3-3          / arr[2](3) = arr[0](2) => 2-1-2 
	    			  arr[j] = key; // arr[0] = key(arr[1] 2')  => arr[1] = 3 , 2-3-1  /  arr[1](3) = key(arr[2] 1) => 2-1-3      / arr[0](2) = key(arr[1] 1) => 1-1-2 
	    		  }
	    		
	    	  }
	    	  pre++;
	      
	      }
	      System.out.println(Arrays.toString(arr));

	}


}
