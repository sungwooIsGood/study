package dataStructure;

import java.util.Arrays;

// 배열로 stack구현 linkedList로도 구현도 가능하다.
public class StackStructure {
	
	private Object[] stack;
	private int lastIndex;
	private Object[] newStack;
	
	private StackStructure() {
		stack = new Object[4];
		lastIndex = -1; // index는 0으로 시작하기 때문에 
	}
	
	public void push(Object input) {
		
		if(lastIndex < stack.length - 1) { 
			if(stack[0] == null) {
				stack[0] = input;
			} else {
				stack[lastIndex + 1] = input;
			}
			
			lastIndex++; // 3
		} else {
			newStack = new Object[stack.length+1]; 
			
			for(int i = 0; i <stack.length; i++) {
				newStack[i] = stack[i];
			}
			stack = newStack;
			lastIndex++; 
			stack[lastIndex] = input; 
		}
		
	}
	
	// stack 맨위에 있는 값을 리턴 한 후 맨위에 데이터를 뺀다.
	public Object pop() {
		
		Object lastIndexPop = stack[lastIndex];
		
		newStack = new Object[lastIndex]; 
		for(int i = 0; i < newStack.length; i++) {
			newStack[i] = stack[i];
		}
				
		stack = newStack;
		lastIndex--;
		System.out.println(lastIndex);
		return lastIndexPop;
	}
	
	// stack 맨위에 있는 값을 리턴 한 후 데이터에 변동은 없다.
	public Object peek() {
		Object lastIndexPeek = stack[lastIndex]; 
		return lastIndexPeek;
	}
	
	public boolean isEmpty() {
		if(lastIndex == -1) {
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		StackStructure stack = new StackStructure();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		System.out.println("stack안에 있는 값: " + Arrays.toString(stack.stack));

		System.out.println("pop메소드 리턴값: " + stack.pop());
		System.out.println("pop메소드 실행 이후 stack안에 있는 값: " + Arrays.toString(stack.stack));
		
		System.out.println("peek메소드 리턴값: " + stack.peek());
		System.out.println("peek메소드 실행 이후 stack안에 있는 값: " + Arrays.toString(stack.stack));
		
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		System.out.println("stack안에 있는 값: " + Arrays.toString(stack.stack));
		System.out.println("isEmpty메소드 실행: " + stack.isEmpty());
	} 
}
