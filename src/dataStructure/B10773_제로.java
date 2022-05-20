package dataStructure;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B10773_제로 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		
		int n = 0;
		
		for(int i = 0; i < test; i++) {
			
			n = Integer.parseInt(br.readLine());
			
			if(n == 0) {
				stack.pop();
			} else {
				stack.push(n);
			}
		}
		
		int result = 0;

		for(int i : stack) {
			result += i;
		}
		System.out.println(result);
	}

}
