package chapter8.inner;

class Node {	
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

class LinkedList { // 노드의 제일 앞. 헤드부분. 배열은 일단 제쳐두고.
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

public class 리스트클래스 {
	public static void main(String[] args) {
		LinkedList my = new LinkedList();
		my.add("hong");
		my.add("kim");
		my.add("lee");
		my.add("park");
		my.add("Ko");
		my.show();

	}

}
