package dataStructure;

import java.util.ListIterator;

public class LinkedList {

	private Node head; // 첫번째 노드
	private Node tail; // 마지막 노드
	private int size = 0; // 노드 사이즈
		
	private class Node{ // inner클래스로 하나의 객체를 의미
		private Object data; // 각각의 노드의 데이터
		private Node next; // 다음노드에 대한 정보
		
		// node 생성자
		public Node(Object input/*노드의 값이 input을 통해 들어온다*/) {
			this.data = input;
			this.next = null;
		}
			
		public String toString() {
			return String.valueOf(this.data);
		}
	}
	
	// 첫부분의 추가
	public void addFirst(Object input) {
		
		Node newNode = new Node(input); //data = 30, next = null / data = 20, next = null;
		newNode.next = head; // 처음은 null / data = 20, next = 30
		head = newNode; // Node head = new Node(input) <- 30 / head => data = 20, next = 30
		size++; // 크기는 0 -> 1 / 1 -> 2
		
		if(head.next == null) {// head의 다음정보값이 null이면
			tail = head; // size는 1인 노드값이 하나인 상황
		}
	}
	
	// 마지막부분에 추가
	public void addLast(Object input) {		

		Node newNode = new Node(input); //data = 30, next = null
		
		if(size == 0) {
			addFirst(input);
			System.out.println("노드 하나가 하나인 경우로 tail과 head값이 동일" + tail + ":" + head);
		} else {
			tail.next = newNode; // tail.next = new Node(input); tail을 가르키는 next값을 tail될 값과 같이 만들어준다.
			System.out.println("tail= " + tail);
			System.out.println("tail.next= " + tail.next);
			tail = newNode;
			System.out.println("tail에 새로들어온 data값을 넣어준다. " + tail);
			size++;
		}
		
	}
	
	// 중간에 추가, 인덱스에 있는 데이터를 알 수 있는 메소드
	private Node node(int index) { // API사용

		Node x = head;
		// 인덱스가 추가 될 때마다, x = x.next라는 규칙성을 가진다.
//		x = x.next; //첫번째 헤드의 next값 <- x = head.next;
//		x = x.next; //두번째 헤드의 next값
		
		for(int i =0; i < index; i++) {
			x = x.next;
		}
		
		return x;
	}
	
	// 특정한 위치에 add시키기
	public void add(int k, Object input) { // k= 노드 인덱스상의 위치 

		if(k == 0) {
			addFirst(input);
		} else {
			// ex) 인덱스 1번에 15번을 추가하고 싶을 때
			// 위치 시키고자 하는 이전 노드의 값을 알아야한다. 노드를 끊고 새로운 노드값을 연결해야한다.
			Node temp1 = node(k-1); // 해당 데이터의 전 인덱스에 있는 데이터. 
			Node temp2 = temp1.next; // temp1이 node(k-1) 이면 temp2는 node(k)값 값이 대입되기전 원래 인덱스이다.
			// 새롭게 대입 될 노드
			Node newNode = new Node(input);
			temp1.next = newNode;
			newNode.next = temp2;
			System.out.println(temp1.next +":" + newNode);
			size++;
			
			if(newNode.next == null) {
				tail = newNode;
			}
		}
	}
	
	// 조회
	public String toString() {
		if(head == null) { // size=0
			return "[]";
		} 
		Node temp = head;
		String str = "[";
		
		while(temp.next != null) {
			str += temp.data + ", ";
			temp = temp.next;
		}
		str += temp.data; //tail값
		
		return str + "]";
	}
	
	// 첫번째 인덱스 삭제
	public Object removeFirst() { // 실제 remove 시 삭제된 값을 리턴하는 방식을 구현
		
		Node temp = head;
		head = head.next;
		Object returnData = temp.data; // 컬렉션 프레임워크는 삭제 전 리턴을 해주고 삭제를 해준다.
		temp = null;
		size--;
		return returnData;
	}
	
	// 특정 인덱스 삭제
	public Object remove(int k) {
			
		if(k == 0) {
			return removeFirst();
		} else {
			Node temp = node(k-1); // k-1번째 노드를 temp에 저장
			Node todoDeleted = temp.next; // 삭제 노드를 todoDelete에 저장
			
			// 삭제노드대신 전 노드와 다음 노드를 연결한다.
			temp.next = temp.next.next;
			
			// 컬렉션 프레임워크에 특징인 삭제할 데이터를 삭제 직전에 리턴받는다.
			Object returnData = todoDeleted.data;
			
			if(todoDeleted == tail) {
				tail = temp;
			}
			
			todoDeleted = null;
			size--;
			
			return returnData;
		}
		
	}
	
	// LinkedList는 인덱스 맨 마지막을 삭제하면 하나씩 순차적으로 찾기 때문에 오랜 시간을 거친다. 반면 arrayList는 마지막 배열 시간 수열
	public Object removeLast() {
		return remove(size-1);
	}
	
	// 엘리먼트의 크기 / 사이즈값을 통해 값을 빠르게 가져올 수 있다. 만약 모른다면 특정 조건이 있을 때까지 next를 통해 찾는거 보다 빠르기 때문에
	public int size() {
		return size;
	}
	
	// 인덱스를 통해 값을 얻기
	public Object get(int k) {
		Node temp = node(k);
		return temp.data;
	}
	
	// 특정 데이터 탐색 / 위치 조회
	public int indexOf(Object data) {
		Node temp = head;
		
		// 찾고자 하는 위치
		int index = 0;
		
		// temp.data == data가 되면 중지
		while(temp.data != data) {
			temp = temp.next;
			index++;
			
			// 가장 끝에 있는 노드에 도달한 것
			if(temp.data == null) {
				return -1;
			}
		}
		return index;
	}
	
	// iterator(반복자)
	public ListIterator listIterator() {
		return new ListIterator();
	}
	
	public class ListIterator {
		
		private Node next;
		private Node lastReturned;
		private int nextIndex;
		
		// next는 맨처음을 가르킨다
		ListIterator(){
			next = head;
		}
		
		// next()메소드는 컬렉션에서 하나의 객체를 가져온다! (현재 데이터를 가져오고 다음 인덱스를 가르킨다.)
		// next()는 Node의 값과 Node의 next값을 동시에 가지고 있다.
		public Object next() {
			lastReturned = next; // lastReturned는 현재(Node) (ListIterator)next를 가르키며 기록해놓는다.
			next = next.next; // .뒤에 오는 next는 다음 노드를 가르키는next이다.
			// 몇번째 인덱스를 가르키는지 내부적으로 저장할 필요가 있다.(hasNext를 위해)
			nextIndex++;
			return lastReturned.data;
		}
		
		//next를 더 실행이 가능한지, hasNext()를 통해 다음 Node가 있는지 알 수 있다.
		public boolean hasNext() {
			return nextIndex < size();
		}
		
		// next를 통해 값을 add 
		public void add(Object input) {
			Node newNode = new Node(input);

			// head와 tail값이 같은 즉, 값이 하나인 경우 next는 head를 lastReurned는 null을 가르킨다.
			if(lastReturned == null) {
				// 처음 add
				head = newNode;
				newNode.next = next;
			} else {
				// 중간 add
				lastReturned.next = newNode;
				newNode.next = next; // 새로들어온 값이 next()안에 있는 next = next.next;를 가르킨다는 뜻
			}
		
			lastReturned = newNode;
			size++;
		}
		
		// lastReturned의 값을 삭제
		public void remove() {
			if(nextIndex == 0) { // next를 한번도 호출 안한 상태. 아무런 엘리먼트를 선택하지 않았다는 뜻.
				throw new IllegalStateException();
			} else {
				LinkedList.this.remove(nextIndex-1);
				nextIndex--;
			}
		}
	}
	
	
}
