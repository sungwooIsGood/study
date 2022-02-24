package twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class B9007 {
	
	// 300 4
	// 60 52 80 40
	// 75 68 88 63
	// 48 93 48 54
	// 56 73 49 75
	
	// 예시에서 n( 1 ≤ n ≤ 1,000 )했으니 1000->n^2 라는 것을 도출
	// 4개의 배열을 두개의 배열로 바꾸기
	// (60+75),(60+68),(60+88),(60+63)...
	//    s ->                           
	// (48+56),(48+73),(48+49),(48+75)...
	//                              <- e
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int test = sc.nextInt();
		
		for(int k = 0; k < test; k++) {
			// n명의 총합 몸무게
			int weight = sc.nextInt();
			// 반 인원
			int c = sc.nextInt();
			
			// 한반의 학생들의 몸무게를 넣어논 배열 크기
			int[][] arr = new int[4][c];
			
			// 반 학생들의 개별 몸무게
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < c; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			// arr1과 2를 합친 배열
			int[] a = new int[c * c];
			int[] b = new int[c * c];
			
			int cnt = 0;
			for(int i = 0; i < c; i++) {
				for(int j = 0; j < c; j++) {		
					a[cnt] = arr[0][i] + arr[1][j];
//					System.out.println(Arrays.toString(a));
					b[cnt] = arr[2][i] + arr[3][j];
					cnt++;
//					System.out.println(cnt);
				}
			}
			Arrays.sort(a);
			Arrays.sort(b);
			
			int s = 0;
			int e = b.length-1;
			// 근사값을 찾기 위한 값
			int xy = a[s] + b[e];
//			System.out.println(Arrays.toString(a));
//			System.out.println(Arrays.toString(b));
			while(s < a.length && e > 0) {
				if(Math.abs(xy - weight) > Math.abs(a[s] +b[e]-weight)) {
					xy = a[s] + b[e];
				}
				
				if(a[s] + b[e] > weight) {
					e--;
				} else {
					s++;
				}
			}
			
			System.out.println(xy);
		}

	}

}
