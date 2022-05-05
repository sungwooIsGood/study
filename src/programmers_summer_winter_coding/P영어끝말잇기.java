package study;

import java.util.ArrayList;

public class P영어끝말잇기 {

	public static void main(String[] args) {
		
		int n = 2;
		String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};
		
		// 끝말과 첫말이 똑같아야한다.
		// 똑같은 단어가 있으면 안된다.
		
		int[] answer = new int[2];
		
		int number = 0;
		
		// 나왔던 단어
		ArrayList<String> list = new ArrayList<>();
		list.add(words[0]);
		
		for (int i = 1; i < words.length; i++) {
			
			// 나왔던 단어 체크
			if(list.contains(words[i])) {
				number = i;
				break;
			}
			
			list.add(words[i]);
			// 시작과 끝 스펠링 체크
			char last = words[i-1].charAt(words[i-1].length()-1);
			char now = words[i].charAt(0);
			if(last != now) {
				number = i;
				break;
			}
			
		}
		if(number != 0) {
			answer[0] = (number % n)+1;
			answer[1] = (number / n)+1;
		}
		System.out.println(answer[0] + "," + answer[1]);
	}

}
