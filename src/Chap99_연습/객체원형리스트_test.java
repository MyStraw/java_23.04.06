package Chap99_연습;

/*
 * 정수 리스트 > 객체 리스트> 객체 원형 리스트
 */
import java.util.Comparator;
import java.util.Scanner;

class SimpleObject3 {
	static final int NO = 1; // 번호를 읽어 들일까요?
	static final int NAME = 2; // 이름을 읽어 들일까요?

	private String no; // 회원번호
	private String name; // 이름

	// --- 문자열 표현을 반환 ---//
	public String toString() {
		return "(" + no + ") " + name;
	}

	public SimpleObject3(String no, String name) {
		this.no = no;
		this.name = name;
	}

	public SimpleObject3() {
		this.no = null;
		this.name = null;
	}

	// --- 데이터를 읽어 들임 ---//
	void scanData(String guide, int sw) {
		Scanner sc = new Scanner(System.in);
		System.out.println(guide + "할 데이터를 입력하세요." + sw);

		if ((sw & NO) == NO) { // & 는 bit 연산자임
			System.out.print("번호: ");
			no = sc.next();
		}
		if ((sw & NAME) == NAME) {
			System.out.print("이름: ");
			name = sc.next();
		}
	}

	// --- 회원번호로 순서를 매기는 comparator ---//
	public static final Comparator<SimpleObject3> NO_ORDER = new NoOrderComparator();

	private static class NoOrderComparator implements Comparator<SimpleObject3> {
		public int compare(SimpleObject3 d1, SimpleObject3 d2) {
			return (d1.no.compareTo(d2.no) > 0) ? 1 : (d1.no.compareTo(d2.no) < 0) ? -1 : 0;
		}
	}

	// --- 이름으로 순서를 매기는 comparator ---//
	public static final Comparator<SimpleObject3> NAME_ORDER = new NameOrderComparator();

	private static class NameOrderComparator implements Comparator<SimpleObject3> {
		public int compare(SimpleObject3 d1, SimpleObject3 d2) {
			return d1.name.compareTo(d2.name);
		}
	}
}

class Node3 {
	SimpleObject3 data;
	Node3 link;

//	public Node3() { //현진버전.추가
//		data = null;
//		link = this;
//	}

	public Node3(SimpleObject3 element) {
		data = element;
		link = null;
	}
}

class CircularList {
	Node3 first;
//	Node3 first = new Node3();//짝지버전.추가. 이거 쓸라면 아래꺼 4줄 주석. 위에줄 주석

	public CircularList() { // head node
		Node3 newNode = new Node3(null); // 빈 노드 하나 만들었다. data = null, 노드(링크)도 null.
		newNode.link = newNode; // 자기자신 가르켜. 처음껀
		first = newNode;
	}

	public int Delete(SimpleObject3 element, Comparator<SimpleObject3> cc) // delete the element

//	 {
//		    Node3 p = first.link; // 현재 노드
//		    Node3 q = first; // 이전 노드
//		    Node3 r = first; // 마지막 노드
//
//		    // 마지막 노드를 찾는 루프
//		    while (r.link != first) {
//		        r = r.link;
//		    }
//
//		    do {
//		        if (cc.compare(element, p.data) == 0) {
//		            if (p == first.link) { // 첫 번째 노드를 삭제하는 경우
//		                first.link = p.link; // 첫 번째 노드를 다음 노드로 변경
//		                r.link = first.link; // 마지막 노드의 링크를 갱신
//		                return 1;
//		            } else { // 첫 번째 노드가 아닌 노드를 삭제하는 경우
//		                q.link = p.link;
//		                return 1;
//		            }
//		        } else {
//		            q = p;
//		            p = p.link;
//		        }
//		    } while (p != first.link);
//		    return -1; // 삭제할 노드를 찾지 못한 경우
//		}

	// -----------------------------
	{
		Node3 p = first.link, q = first;
		Node3 r = first; // 첫 번째 노드를 가리키는 참조 변수 추가

		if (p == q) { // 리스트에 요소가 하나 뿐인 경우
			if (cc.compare(element, p.data) == 0) {
				first = null; // 리스트의 유일한 요소 삭제
			}
			return -1;
		}

		while (p != first) {
			if (cc.compare(element, p.data) == 0) {
				if (p == r) { // 첫 번째 노드를 삭제하는 경우
					first = p.link;
					r = first;
					q.link = r;
					p = p.link;
				} else { // 중간 노드를 삭제하는 경우
					q.link = p.link;
					p = p.link;
				}
				return 1; // 삭제한 후 반복문 종료
			}
			q = p;
			p = p.link;
		}

		// 맨 끝 노드를 삭제하는 경우
		if (cc.compare(element, q.data) == 0) {
			p.link = first;
		}
		return -1;
	}

	public void Show() { // 전체 리스트를 순서대로 출력한다.
		Node3 nd = first.link;
		while (nd != first) {
			System.out.println(nd.data + " ");
			nd = nd.link;
		}
		System.out.println();
	}

	public void Add(SimpleObject3 element, Comparator<SimpleObject3> cc) // 임의 값을 삽입할 때 리스트가 오름차순으로 정렬이 되도록 한다

//	{
//		Node3 temp = new Node3(element); // head 노드 사용해서 구현해보셈
//		Node3 p = first.link, q = first; // q 다음이 p
//
//		if (p == q) { // first만 있으면 갖다 붙여라
//			first.link = temp; // first가 가리키는게 temp가 돼야하고
//			temp.link = first; // temp가 가리키는게 다시 first를. 마지막이 처음 가르켜야.
//			return;
//		}
//		while (p != first) { //while 이 안돈다.
//			if (cc.compare(element, p.data) < 0) {
//				if (q == first) { // 데이터없는 첫노드가 q
//					temp.link = p; // first - 10 - 20 - 30 사이에 5가 끼었을때.
//					first.link = temp;
//					return;
//				} else {
//					temp.link = p;
//					q.link = temp;
//					return;
//				}
//			} else if (cc.compare(element, p.data) >= 0) {
//				q = p;
//				p = first;
//				q.link = temp;
//				temp.link = p;
//				return;
//			}
////				q = p;
////				p = p.link;// 이걸 함으로써 다음으로 옮겨.
////				if (p == null) {
////					q.link = temp;
//		}
//	}

//	{
//	    Node3 temp = new Node3(element);
//	    Node3 p = first.link, q = first; // q 다음이 p
//
//	    while (p != first) { // 리스트를 순회합니다.
//	        if (cc.compare(element, p.data) < 0) { // 삽입할 노드의 위치를 찾았습니다.
//	            temp.link = p; // 새 노드가 현재 노드를 가리키도록 합니다.
//	            q.link = temp; // 이전 노드가 새 노드를 가리키도록 합니다.
//	            return;
//	        }
//	        q = p; // 이전 노드를 현재 노드로 갱신합니다.
//	        p = p.link; // 현재 노드를 다음 노드로 갱신합니다.
//	    }
//
//	    // 삽입하려는 노드가 리스트의 모든 노드보다 큰 경우, 리스트의 마지막에 삽입합니다.
//	    q.link = temp; // 이전 노드가 새 노드를 가리키도록 합니다.
//	    temp.link = first; // 새 노드가 첫 번째 노드를 가리키도록 합니다. (원형 리스트이므로)
//	}	

//	{
//	Node3 nd = new Node3(element);
//	Node3 p = first;
//	Node3 q = null;
//	if (p == null) {
//		first = nd;
//		return;
//	}
//	while (p != null) {
//		if (cc.compare(element, p.data) < 0) {
//			if (p == first) { // p가 첫번째일때
//				nd.link = p;
//				first = nd;
//				return;
//			} else { // p가 첫번째가 아닐때
//				nd.link = p;
//				q.link = nd;
//				return;
//			}
//		} else if (cc.compare(element, p.data) > 0) {
//			q = p;
//			p = p.link;
//			if (p == null) {
//				q.link = nd;
//				return;
//			}
//		}
//		if (p == first) { // 마지막 노드일 경우 첫 번째 노드와 연결
//			q.link = nd;
//			nd.link = first;
//			break;
//		}
//
//	}
//
//}

	// -----------------------------------------

	{
		Node3 temp = new Node3(element);
		Node3 p = first.link, q = first;

		if (p == q) {
			first.link = temp;
			temp.link = first;
			return;
		}

		while (p != first) {
			if (cc.compare(element, p.data) < 0) {
				if (q == first) {
					temp.link = p;
					first.link = temp;
					return;
				} else {
					temp.link = p;
					q.link = temp;
					return;
				}
			} else if (cc.compare(element, p.data) > 0) {
				q = p;
				p = p.link;
			} else {
				System.out.println("The node already exists.");
				return;
			}
		}

		// If the inserted element is the largest, add to the end of the list
		q.link = temp;
		temp.link = first;
	}

	public boolean Search(SimpleObject3 element, Comparator<SimpleObject3> cc) { // 전체 리스트를 순서대로 출력한다.
		Node3 p = first;
		while (p != null) {
			if (cc.compare(element, p.data) == 0) {
				return true;
			}
			p = p.link;
		}
		return false;
	}
}

public class 객체원형리스트_test {
	enum Menu {
		Add("삽입"), Delete("삭제"), Show("인쇄"), Search("검색"), Exit("종료");

		private final String message; // 표시할 문자열

		static Menu MenuAt(int idx) { // 순서가 idx번째인 열거를 반환
			for (Menu m : Menu.values())
				if (m.ordinal() == idx)
					return m;
			return null;
		}

		Menu(String string) { // 생성자(constructor)
			message = string;
		}

		String getMessage() { // 표시할 문자열을 반환
			return message;
		}
	}

	// --- 메뉴 선택 ---//
	static Menu SelectMenu() {
		Scanner sc = new Scanner(System.in);
		int key;
		do {
			for (Menu m : Menu.values()) {
				System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
				if ((m.ordinal() % 3) == 2 && m.ordinal() != Menu.Exit.ordinal())
					System.out.println();
			}
			System.out.print(" : ");
			key = sc.nextInt();
		} while (key < Menu.Add.ordinal() || key > Menu.Exit.ordinal());
		return Menu.MenuAt(key);
	}

	public static void main(String[] args) {
		Menu menu; // 메뉴
		System.out.println("Linked List");
		CircularList l = new CircularList();
		Scanner sc = new Scanner(System.in);
		SimpleObject3 data;
		System.out.println("inserted");
		l.Show();
		do {
			switch (menu = SelectMenu()) {
			case Add: // 머리노드 삽입
				data = new SimpleObject3(); // 빈 객체를 만들고(비어있는애.) | | |
				data.scanData("입력", 3); // 비어있는 애에 데이터 넣고.
				l.Add(data, SimpleObject3.NO_ORDER);
				break;
			case Delete: // 머리 노드 삭제
				data = new SimpleObject3();
				data.scanData("삭제", SimpleObject3.NO);
				int num = l.Delete(data, SimpleObject3.NO_ORDER);
				System.out.println("삭제된 데이터 성공은 " + num);
				break;
			case Show: // 꼬리 노드 삭제
				l.Show();
				break;
			case Search: // 회원 번호 검색
				data = new SimpleObject3();
				data.scanData("탐색", SimpleObject3.NO);
				boolean result = l.Search(data, SimpleObject3.NO_ORDER);
				if (result == true)
					System.out.println("검색 성공 = " + result);
				else
					System.out.println("검색 실패 = " + result);
				break;
			case Exit: // 꼬리 노드 삭제
				break;
			}
		} while (menu != Menu.Exit);
	}
}
