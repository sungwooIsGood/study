package sort;

import java.util.Arrays;

public class MergeSort {
	
	// 분할하는 메소드
	public static void mergesort(int[] arr, int[]temp, int first, int last) { 
		
		if(first < last) {
			int mid = (first + last) / 2; 
			// first, mid, last는 arr의 index를 가르킨다.
			mergesort(arr,temp,first,mid); 
			mergesort(arr,temp,mid+1,last);
			System.out.println(first + " " + mid + " " + last);
			merge(arr,temp,first,mid,last);
		}
  	}
	
	// 병합하는 메소드
	public static void merge(int[] arr, int[] temp, int first, int mid, int last) {
		
		for(int i = first; i <=last; i++) {
			temp[i] = arr[i];
		}
//		System.out.println(Arrays.toString(temp));
		
		int left = first; // 0
		int right = mid +1; // 2
		int index = first; // 0
		
		while(left <= mid && right <= last) {
			if(temp[left] <= temp[right]) {
				arr[index] = temp[left];
				left++;
			} else {
				arr[index] = temp[right];
				right++;
			}
			index++; // 1
			System.out.println(Arrays.toString(arr));
		}
//		System.out.println(Arrays.toString(arr));
//		System.out.println("===========");
		
		// 뒤쪽이 먼저 끝나게 됐을 경우 앞쪽에 있는 값들을 정리
		for(int i = 0; i <=mid-left; i++) {
			arr[index+i] = temp[left+i];
		}
	}
	
	public static void main(String[] args) {
		
		// 정렬안된 배열
		int[] arr = {5,4,3,6,1,9,6,0};
		// 정렬할 배열
		int[] temp = new int[arr.length];

		System.out.println("정렬 전 배열");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		System.out.println();
		
		mergesort(arr,temp,0,arr.length-1);
		
		System.out.println("정렬 후 배열");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
	}

}
