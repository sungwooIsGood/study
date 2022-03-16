package Greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class B1946_신입사원 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < testCase; i++) {
			
			int people = Integer.parseInt(br.readLine());
			
			int[][] arr = new int[people][2];
			
			for(int j = 0; j < people; j++) {
				String[] s = br.readLine().split(" ");
				arr[j][0] = Integer.parseInt(s[0]);
				arr[j][1] = Integer.parseInt(s[1]);
			}
			
			// 다중배열 정렬 
			Arrays.sort(arr,new Comparator<int[]>(){
				
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[0] - o2[0];
				}
			});
			
			int count = 1;
			int max = arr[0][1];
			
			for(int k = 1; k < people; k++) {
				if(max > arr[k][1]) {
					max = arr[k][1];
					count++;
				}
			}
			System.out.println(count);
		}
	
	}

}
