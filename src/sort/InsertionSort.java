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
	    	  
	    	  for(int j = pre; j >= 0; j--) { 
	    		  
	    		  if(arr[j] > key) {                                      
	    			  arr[j+1] = arr[j]; 
	    			  arr[j] = key; 
	    		  }
	    		
	    	  }
	    	  pre++;
	      
	      }
	      System.out.println(Arrays.toString(arr));

	}


}
