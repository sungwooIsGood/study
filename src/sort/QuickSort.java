package sort;

import java.util.Arrays;

public class QuickSort {
	
	public static void quickSort(int[] arr,int first,int last) {
	
		if(first < last) {
            int pivot = first;
            int i = first + 1; // 오른쪽으로 가며 pivot보다 큰 값 찾는 것
            int j = last; // 왼쪽으로 가며 pivot보다 작은 값 찾는 것
            // swap을 위한 임시 변수
            int temp = 0;
            // i와 j가 엇갈리면 pivot값과 j값을 바꾼다.
            while(i <= j) {
               // pivot데이터 보다 크면 멈춘다.
               while(i <= last && arr[i] <= arr[pivot]) {               
                  i++;
               }
            // pivot데이터 보다 작으면 멈춘다.
               while(j > first && arr[j] >= arr[pivot]) {
                  j--;
               }
               
               if(i > j) {
                  // j와 i가 엇갈릴 때 pivot과 j의 교환
                  temp = arr[j];
                  arr[j] = arr[pivot];
                  arr[pivot] = temp;
               } else {
                  // j는 pivot보다 작은 값을 찾았고, i는 pivot보다 큰값을 찾았을 때 일반 적인 상황에서의 교환
                  temp = arr[j];
                  arr[j] = arr[i];
                  arr[i] = temp;
               }
            }
            
            quickSort(arr,first,j-1);
            quickSort(arr,j+1,last);
         }
		

	}

	
	public static void main(String[] args) {
		int[] arr = {70,20,50,10,30,40};
		System.out.println("quickSort진행 전: " + Arrays.toString(arr));
		quickSort(arr,0,arr.length-1);
		
		System.out.println("quickSort진행 후: " + Arrays.toString(arr));
	}
}
