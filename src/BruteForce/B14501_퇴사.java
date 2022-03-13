package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class B14501_퇴사 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 퇴사날 까지 남은 일수
		int days = Integer.parseInt(br.readLine());
		
		// 
		Map<Integer,Integer> map = new HashMap<>();
		
		// 배열채우기
		for(int i = 0; i < days; i++) {
			String[] s = br.readLine().split(" ");
			map.put(Integer.parseInt(s[0]),Integer.parseInt(s[1]));
		}
		
		// days보다 작은 일수들
		int temp = 0;
		// 급여 최대값
		int sum = 0;
		
		
		for(int i = 0; i < days; i++) {
			
			if(temp + map.keySet() <=days) {
				
			}
		}
		
	}

}
