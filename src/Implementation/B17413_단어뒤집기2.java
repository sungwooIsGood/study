package Im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class B17413_단어뒤집기2 {

	public static void main(String[] args) throws IOException {

		// <> 사이는 그대로 출력
		// 나머지는 뒤집어서 그 자리에 출력
		
		// 뒤집는 것은 => stack 이용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	

		// 뒤집기
		Stack<Character> stack = new Stack<>();
		
		// 다시 넣기
		StringBuilder sb = new StringBuilder();
		
		// <ab cd>ef gh<ij kl>
		String ss = br.readLine();
		char[] cArr = ss.toCharArray();
		
		
		// '<' || '>' 확인용
		boolean check = false;
		
		for(int i = 0; i < cArr.length; i++) {
//			'<' 넣기
			if(cArr[i] == '<') {
				check = true;
				
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				sb.append(cArr[i]);
				
//			' ' '<'||'>' 안에서 말고 밖에서 띄어쓰기 일 때 넣어주기	
			} else if(cArr[i] == ' ') {
				while (!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				sb.append(' ');
			} else if(cArr[i] == '>') {
				check = false;
				sb.append('>');
//			ckeck => '<' '>' 안에 있는 값 넣기 '<' => true, '>' => false 				
			} else if(check) {
				sb.append(cArr[i]);
			} else {
				stack.push(cArr[i]);
			}
			
//			마지막 push했던 것들 다 stack에서 빼기
		}
		
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		System.out.println(sb);

	}



}
