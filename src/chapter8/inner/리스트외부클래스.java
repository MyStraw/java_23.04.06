package chapter8.inner;

class LinkedList2 { // 노드의 제일 앞. 헤드부분. 배열은 일단 제쳐두고.//이미 이름 있어서 2 붙였다. 앞에꺼 복붙하고 순서만 바꾼거라.
	static class Node { //static 368p. 객체 안만들어도 사용되게.
		String data;
		Node link; // 일단 필드만 우선 정해. 클래스 써내려갈때.

		Node(String data) {
			this.data = data;
			link = null;
		}

		public String toString() {
			return "data = " + data;
		}
	}

	Node head;

	void show() {
		Node p = head;
		while (p != null) {
			System.out.println(p.toString());
			p = p.link;
		}
	}

	void add(String name) {
		Node temp = new Node(name);
		if (head == null) {
			head = temp;
		}

		else {
			temp.link = head;
			head = temp;
		}
	}
}

public class 리스트외부클래스 {
	public static void main(String[] args) {
		LinkedList2 my = new LinkedList2();
		my.add("hong");
		my.add("kim");
		my.add("lee");
		my.add("park");
		my.add("Ko");
		my.show();
	}
}
