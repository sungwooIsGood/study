package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class B1026_보물 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
	
		Integer[] a = new Integer[n];
		Integer[] b = new Integer[n];
		
		int temp = 0;
		
		String[] s = br.readLine().split(" ");
		
		for(int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(s[i]);
		}
		
		String[] ss = br.readLine().split(" ");
		
		for(int i = 0; i < n; i++) {
			b[i] = Integer.parseInt(ss[i]);
		}
		
		Arrays.sort(a);
		Arrays.sort(b, Collections.reverseOrder());
		
		for(int i = 0; i < n; i++) {
			temp += a[i] * b[i];
		}
	
		System.out.println(temp);
	}

}
