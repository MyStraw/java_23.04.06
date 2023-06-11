package Chap9_트리;

/*
 * 23.6.7 3회차 실습코드 
 */
import java.util.Comparator;
import java.util.Scanner;

class SimpleObject2 {
	static final int NO = 1; // 번호를 읽어 들일까요?
	static final int NAME = 2; // 이름을 읽어 들일까요?

	private String no; // 회원번호
	private String name; // 이름

	// --- 문자열 표현을 반환 ---//
	public String toString() {
		return "(" + no + ") " + name;
	}

	public SimpleObject2() {
		no = null;
		name = null;
	}

	public SimpleObject2(String no, String name) {
		this.no = no;
		this.name = name;
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
	public static final Comparator<SimpleObject2> NO_ORDER = new NoOrderComparator();

	private static class NoOrderComparator implements Comparator<SimpleObject2> {
		public int compare(SimpleObject2 d1, SimpleObject2 d2) {
			return (d1.no.compareTo(d2.no) > 0) ? 1 : (d1.no.compareTo(d2.no) < 0) ? -1 : 0;
		}
	}

	// --- 이름으로 순서를 매기는 comparator ---//
	public static final Comparator<SimpleObject2> NAME_ORDER = new NameOrderComparator();

	private static class NameOrderComparator implements Comparator<SimpleObject2> {
		public int compare(SimpleObject2 d1, SimpleObject2 d2) {
			return d1.name.compareTo(d2.name);
		}
	}
}

//정수를 저정하는 이진트리 만들기 실습
class TreeNode4 {
	TreeNode4 LeftChild;
	SimpleObject2 data;
	TreeNode4 RightChild;

	public TreeNode4() {
		LeftChild = RightChild = null;
	}

	TreeNode4(SimpleObject2 so) {
		data = so;
		LeftChild = RightChild = null;
	}
}

class Tree4 {
	TreeNode4 root;

	Tree4() {
		root = null;
	}

	TreeNode4 inorderSucc(TreeNode4 current) {
		TreeNode4 temp = current.RightChild;
		if (current.RightChild != null)
			while (temp.LeftChild != null) {
				temp = temp.LeftChild;
			}
		return temp;
	}

	TreeNode4 findParent(TreeNode4 current, Comparator<? super SimpleObject2> c) {
		TreeNode4 p = root, temp = null;
		while (p != null) {
			if (c.compare(p.data, current.data) == 0) {
				return temp;
			} else if (c.compare(p.data, current.data) < 0) {
				temp = p;
				p = p.RightChild;
			} else {
				temp = p;
				p = p.LeftChild;
			}
		}
		return null;
	}

	boolean isLeafNode(TreeNode4 current) {
		if (current.LeftChild == null && current.RightChild == null)
			return true;
		else
			return false;
	}

	void inorder() {
		inorder(root);
	}

	void preorder() {
		preorder(root);
	}

	void postorder() {
		postorder(root);
	}

	void inorder(TreeNode4 CurrentNode) {
		if (CurrentNode != null) {
			inorder(CurrentNode.LeftChild);
			System.out.print(" " + CurrentNode.data);
			inorder(CurrentNode.RightChild);
		}
	}

	void preorder(TreeNode4 CurrentNode) {
		if (CurrentNode != null) {
			System.out.print(CurrentNode.data + " ");
			preorder(CurrentNode.LeftChild);
			preorder(CurrentNode.RightChild);
		}
	}

	void postorder(TreeNode4 CurrentNode) {
		if (CurrentNode != null) {
			postorder(CurrentNode.LeftChild);
			postorder(CurrentNode.RightChild);
			System.out.print(CurrentNode.data + " ");
		}
	}

	public boolean add(SimpleObject2 obj, Comparator<? super SimpleObject2> c) {
		TreeNode4 temp = new TreeNode4(obj); // 여기만 만들게 아니라 좌, 우에도 새로 생성해야 하니까. 여기서.
		TreeNode4 p = root; // 링크드로, 빠지지 않게끔 연결. q를 하나 더 써서.
		TreeNode4 q = null;
		if (p == null) { // 암것도 없을때. 새로운 data =x 를 루트로 만들어.
			root = temp; // 루트를 새로 만들어야지.
			return true;
		}
		while (p != null) {
			q = p; // 이전거 q. 그러니 부모? 가 p가 되게끔.
			if (c.compare(obj, p.data) < 0) { // p 데이터보다 삽입하려는게 작은수라면 왼쪽으로 가야지
				p = p.LeftChild;
				if (p == null) { // 근데 삽입 할라니까 왼쪽이 비어있네? 그럼 새로 만들어야지. temp.
					q.LeftChild = temp; // 새로 생성을 해야지.
					return true;
				}
			} else if (c.compare(obj, p.data) > 0) {
				p = p.RightChild;
				if (p == null) {
					q.RightChild = temp; // 새로 생성을 해야지.
					return true;
				}
			} else { // 중복처리
				return false; // 이거 하나 부족.
			}
		}
		return false;
	}

	public boolean delete(SimpleObject2 obj, Comparator<? super SimpleObject2> c) {
		TreeNode4 p = root; // 루트에서부터 출발 해보자잉
		TreeNode4 q = root;
		boolean isLeftChild = true;

		while (c.compare(obj, p.data) != 0) {
			q = p;
			if (c.compare(obj, p.data) < 0) {
				isLeftChild = true;
				p = p.LeftChild;
			} else if (c.compare(obj, p.data) > 0) {
				isLeftChild = false;
				p = p.RightChild;
			}
			if (p == null) {
				return false;
			}
		}

		// 케이스 1 : leaf node 삭제
		if (p.LeftChild == null && p.RightChild == null) {
			if (p == root) {
				root = null;
			}
			if (isLeftChild) { // 위 while에서 true를 해놨으니까...
				q.LeftChild = null; // p의 부모가 q인 상태. p는 q의 왼쪽아이. 그래서 q의 왼쪽아이를 자르면 삭제되겠네
			} else {
				q.RightChild = null;
			}

		}

		// 케이스 2 : child 가 1개인 노드 삭제 //위랑 똑같이 하면 되겠네.
		if (p.RightChild == null) {
			if (p == root) {
				root = p.LeftChild; // p.left?
			}
			if (isLeftChild) {
				q.LeftChild = p.LeftChild; // p.left? 이게 1번. 1이 부모의 왼쪽에 있는애
			} else {
				q.RightChild = p.LeftChild; // 이게 4번. 4가 부모의 오른쪽에 있는 애.
			}

		}
		if (p.LeftChild == null) {
			if (p == root) {
				root = p.RightChild; // p.left?
			}
			if (isLeftChild) {
				q.LeftChild = p.RightChild; // p.left?
			} else {
				q.RightChild = p.RightChild;
			}
		}
		// 케이스 3 : child 가 2개인 노드 삭제. inorderSucc이용
		else {
			TreeNode4 successor = inorderSucc(p);
			if (p == root) {
				root = successor;

			} else if (isLeftChild) {
				q.LeftChild = successor;

			} else {
				q.RightChild = successor;
			}
			successor.LeftChild = p.LeftChild;

		}
		return true;

	}

	boolean search(SimpleObject2 obj, Comparator<? super SimpleObject2> c) {
		TreeNode4 p = root;
		while (p != null) {
			if (c.compare(obj, p.data) == 0) {
				return true;
			} else if (c.compare(obj, p.data) < 0) {
				p = p.LeftChild;
			} else if (c.compare(obj, p.data) > 0) {
				p = p.RightChild;
			}
		}
		return false;
	}
}

public class Chap9_Test_BinaryTree_SimpleObject {

	enum Menu {
		Add("삽입"), Delete("삭제"), Search("검색"), InorderPrint("정렬인쇄"), Exit("종료");

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
		Scanner stdIn = new Scanner(System.in);
		int key;
		do {
			for (Menu m : Menu.values())
				System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
			System.out.print(" : ");
			key = stdIn.nextInt();
		} while (key < Menu.Add.ordinal() || key > Menu.Exit.ordinal());

		return Menu.MenuAt(key);
	}

	public static void main(String[] args) {
		Scanner sc2 = new Scanner(System.in);
		Tree4 t = new Tree4();
		Menu menu; // 메뉴
		String sno1, sname1;
		SimpleObject2 so;
		int count = 0;
		int num;
		boolean result;
		do {
			switch (menu = SelectMenu()) {
			case Add: // 머리노드 삽입
				SimpleObject2[] sox = { new SimpleObject2("33", "ee"), new SimpleObject2("55", "tt"),
						new SimpleObject2("22", "ww"), new SimpleObject2("66", "yy"), new SimpleObject2("21", "wq") };
				for (SimpleObject2 soz : sox)
					t.add(soz, SimpleObject2.NO_ORDER);
				break;
			case Delete: // 머리 노드 삭제
				so = new SimpleObject2();
				so.scanData("삭제", SimpleObject2.NO);
				t.delete(so, SimpleObject2.NO_ORDER);

				break;
			case Search: // 회원 번호 검색
				so = new SimpleObject2();
				so.scanData("검색", SimpleObject2.NO);
				so.scanData("검색", SimpleObject2.NAME); //이게 빠졌네. 이거 추가.
				result = t.search(so, SimpleObject2.NO_ORDER);
				if (result == false)
					System.out.println("검색 값 = " + so + "데이터가 없습니다.");
				else
					System.out.println("검색 값 = " + so + "데이터가 존재합니다.");
				break;

			case InorderPrint: // 전체 노드를 키값의 오름차순으로 표시
				t.inorder();
				System.out.println();
				break;
			case Exit:
				break;
			}
		} while (menu != Menu.Exit);
	}
}
