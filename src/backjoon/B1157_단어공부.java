package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class B1157_단어공부 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Map<String,Integer> map = new HashMap<>();
		
		String s = br.readLine();
		
		s.toUpperCase();
		
		for(int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i),1);
		}
		
		for(int i = 0; i < s.length(); i++) {
			for(int j = i+1; j <= s.length(); j++) {
			}
		}
	}

}
