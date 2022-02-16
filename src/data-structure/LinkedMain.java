package dataStructure;

public class LinkedMain {
	
	public static void main(String[] args) {
		LinkedList numbers = new LinkedList();
//		numbers.addFirst(30); // 첫번째 위치에서 삽입
//		numbers.addFirst(20); // 첫번째 위치에서 삽입
		
		numbers.addLast(30); // 마지막 위치에서 삽입 index:0
		numbers.addLast(20);
		numbers.addLast(10);
		numbers.addLast(50);
		numbers.addLast(30);
		
		
//		System.out.println(numbers.node(0)); // 첫번째 Node / addLast(30)이 노드객체가 리턴된다.

		numbers.add(3,15);
		System.out.println(numbers);
		System.out.println("head 삭제: "+ numbers.removeFirst());
		System.out.println(numbers);
		
		System.out.println("특정 인덱스 번호 리턴: " + numbers.remove(1));
		System.out.println(numbers);
		
		System.out.println("인덱스 번호를 통해 값을 리턴: " + numbers.get(1));
		System.out.println(numbers);
		
		System.out.println("값을 통해 인덱스 번호 리턴: " + numbers.indexOf(20)); // 인덱스 번호 리턴
		System.out.println(numbers);
		
		LinkedList.ListIterator i = numbers.listIterator();
		
		i.add(5); // head에 값을 추가  lastReturned = 5, next = 20
		i.next(); //  lastReturned = 20, next = 15 
		i.add(99); // lastReturned.next = newNode; => 99 , newNode.next = next; => 15 
		
		System.out.println(numbers);
		// iterator
//		while(i.hasNext()) {
//			System.out.println(i.next());
//		}
		
		i.remove();
		System.out.println(numbers);
	}
}
