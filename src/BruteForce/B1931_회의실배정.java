package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class B1931_회의실배정 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		// 그리디 - 활동 선택 문제
		// 종료시간 기준 정렬
		// 가장 빨리 끝나는 것을 선택
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 주어진 시간
		int time = Integer.parseInt(br.readLine());
		
		// 시작 숫자가 가장 작아야 한다
		// 끝나는 시간 보다 커야 한다.
		int[][] arr = new int[time][2];
		
		for(int i = 0; i < time; i++) {
			String[] s = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(s[0]);
			arr[i][1] = Integer.parseInt(s[1]);
		}

		// 종료시간 기준 정렬
		// 다차원 배열 정렬 방법
		// 이해 힘듬...
		Arrays.sort(arr, new Comparator<int[]>() {
			
			@Override
			public int compare(int[] o1, int[] o2) {
				
				// o1[0] - o2[0]은 [i][0]기준 오름차순 정렬
				// o2[0] - o2[1]은 내림차순 정렬
				
				// 종료시간이 같을 경우 시작시간이 빠른 순서 정렬
				if(o1[1] == o2[1]) {
					return o1[0] - o2[0];
				} else {
					return o1[1] - o2[1];
				}
			}
		});
		
		
		// 직전 종료시간이 다음 회의 시작 시간보다 작거나 같다면 카운트
		int count = 0;
		int endTime = 0;
		
		for(int i = 0; i < time; i++) {
			if(endTime <= arr[i][0]) {
				endTime = arr[i][1];
				count++;
			}
		}
		System.out.println(count);
	}

}
