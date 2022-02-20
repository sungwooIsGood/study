package recursive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class B10829 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long num = sc.nextLong();
		
		returning(num);
		
	}
	public static void returning(Long num) {
		
		List<Integer> list = new ArrayList<>();
		
		if(num % 2 ==1) {
			list.add(1);
		} else {
			list.add(0);
		}
		num = num /2;
		
		if(num != 0) {
			returning(num);
		}
		Collections.reverse(list); // 컬렉션에 있는 배열 순서를 바꿔주는 메소드.
		
		for(int i =0; i <list.size(); i++) {			
			System.out.print(list.get(i));
		}
	}
}
