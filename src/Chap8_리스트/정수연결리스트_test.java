package Chap8_리스트;

//단순한 linked list에서 insert, delete하는 알고리즘을 코딩: 1단계

import java.util.Random;
import java.util.Scanner;

class Node1 {
	int data;
	Node1 link; // 뒤쪽 포인터. 객체. 클래스의 인스턴스를 참조(가리키는)하는 참조용 필드다. 객체의 id를 가리킨다.

	public Node1(int element) { // 생성자
		data = element;
		link = null; // 꼬리는 null. 생성자는 매개변수 data, link에 전달받은 값 대입.
	}
}

class LinkedList1 {
	Node1 first; // head. p가 현재 포인터.

	public LinkedList1() { // 생성자
		first = null;
	}

	public int Delete(int element) // delete the element //이거도 처음 delete, 중간 delete, 마지막 delete 3가지 경우.
	// l.delete(20) 이걸 삭제한다면 이게 첫번째에 있는건지 마지막인지 중간인지. 판단한뒤.
	{
		Node1 now = first;
		Node1 left = null;

		if (now == null) { // 처음. first 넣는건데 없으면 걍 없는거지. 리턴
			return -1;
		}

		while (now != null) {
			if (element > now.data) {// 일단 처음이 아니고 현재 커서가 있는 데이터랑 삭제하고픈 데이터가 같지 않을때
				left = now;
				now = now.link;
			}

			else if (element == now.data) {// 일단 처음이 아니고 현재 커서에 있는 데이터가 삭제하고픈 데이터일때
				if (left == null) {
					first = now.link;
					return 1;
				}
			}
		}
		left.link = now.link;
		return -1;
	}

	public void Show() { // 전체 리스트를 순서대로 출력한다.
		Node1 p = first;
		while (p != null) {
			System.out.print(p.data + " ");// p값 출력
			p = p.link;
		}
		System.out.println();
	}

	public void Add(int element) // 임의 값을 삽입할 때 리스트가 오름차순으로 정렬이 되도록 한다
	{ // 10 - 20 - 30 - 40
		Node1 insert = new Node1(element); // 삽입할 노드.q=past, p=now, nd=insert로 바꿈.
		Node1 now = first, past = now; // q는 p를 따라가게 // p가 현재 기존에 있는 포인터.
		if (now == null) {// 1. 처음 넣는거 (아무것도 없을때는 p도 없지.)
			first = insert; // 0부터 시작하는 이세계. 아무것도 없으니까 삽입할 노드가 first가 되겠네.
			return;
		}
		while (now != null) { // 이미 처음은 아니란겨.
			if (element < now.data) { // 3. 마지막 넣는거. p는 첫번째 내가 입력할려는값이 첫번째보다 작다면
				if (past == first) {
					insert.link = now; // 10 앞에 5가 끼어드는 상황.
					first = insert;
					return;
				} else {
					insert.link = now;
					past.link = insert;
					return;
				}
			} else if (element >= now.data) {
				past = now;
				now = now.link;// 이걸 함으로써 다음으로 옮겨.
				if (now == null) {
					past.link = insert;
					return;
				}
			}
		}
	}

	public boolean Search(int data) { // 전체 리스트를 순서대로 출력한다.
		Node1 p = first;
		while (p != null) {
			if (p.data == data) {
				return true;
			}
			p = p.link;
		}
		return false;
	}
}

public class 정수연결리스트_test {
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
	static Menu SelectMenu() { // 314p 하단.
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
		Random rand = new Random();
		System.out.println("Linked List");
		LinkedList1 l = new LinkedList1();
		Scanner sc = new Scanner(System.in);
		int data = 0;
		System.out.println("inserted");
		l.Show();
		do {
			switch (menu = SelectMenu()) {
			case Add: // 머리노드 삽입
				data = rand.nextInt(20);
				// double d = Math.random();
				// data = (int) (d * 50);
				l.Add(data);
				System.out.println(data);
				break;
			case Delete: // 머리 노드 삭제
				data = sc.nextInt();
				int num = l.Delete(data);
				System.out.println("삭제된 데이터는 " + num);
				break;
			case Show: // 꼬리 노드 삭제
				l.Show();
				break;
			case Search: // 회원 번호 검색
				int n = sc.nextInt();
				boolean result = l.Search(n);
				if (result == false)
					System.out.println("검색 값 = " + n + "데이터가 없습니다.");
				else
					System.out.println("검색 값 = " + n + "데이터가 존재합니다.");
				break;
			case Exit: // 꼬리 노드 삭제
				break;
			}
		} while (menu != Menu.Exit);
	}
}

//Node1 nd = new Node1(element);
//Node1 p = first, q = p; // q는 p를 따라가게
//if (p == null) {// 1. 처음 넣는거
//	first = nd;
//	return;
//}
//while (p != null) {
//	if (element < p.data) { // 3. 마지막 넣는거. p는 첫번째 내가 입력할려는값이 첫번째보다 작다면
//		if (q == first) {
//			nd.link = p;
//			first = nd;
//			return;
//		} else {
//			nd.link = p;
//			q.link = nd;
//			return;
//		}
//	} else if (element > p.data) {
//		q = p;
//		p = p.link;// 이걸 함으로써 다음으로 옮겨.
//		if (p == null) {
//
//			return;
//
//		}
//	}
//}