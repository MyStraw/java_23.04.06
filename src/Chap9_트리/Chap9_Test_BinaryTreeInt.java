package Chap9_트리;

/*
 * 23.6.7 3회차 실습 코드
 */
import java.util.Random;
import java.util.Scanner;

//정수를 저정하는 이진트리 만들기 실습
class TreeNode {
	TreeNode LeftChild;
	int data;
	TreeNode RightChild;

	public TreeNode() {
		LeftChild = RightChild = null;
	}

	public TreeNode(int x) { // 이걸 안해줘서 입력이 안됐네.
		// TODO Auto-generated constructor stub
		LeftChild = RightChild = null;
		data = x; // 어차피 클래스 위에서 int data 해줬으니 this 할필요 x
	}
}

class Tree {
	TreeNode root;

	Tree() {
		root = null;
	}

	TreeNode inorderSucc(TreeNode current) { // successor 후계자.인오더 석세스. 왼쪽 맨 아래껄 찾아서 바꿔?. 다음에 올 노드를 말한다.
		TreeNode temp = current.RightChild;
		if (current.RightChild != null)
			while (temp.LeftChild != null)
				temp = temp.LeftChild;
		return temp;
	}

	boolean isLeafNode(TreeNode current) { // 양쪽이 null이면 leaf..? 맨 아래 달랑거린 자식. 리프.
		if (current.LeftChild == null && current.RightChild == null)
			return true;
		else
			return false;
	}

	void inorder() { // 우리 이거 쓸거야. 그래야 정렬. 중위순회
		inorder(root);
	}

	void preorder() { // 전위 순회
		preorder(root);
	}

	void postorder() { // 후위 순회
		postorder(root);
	}

	void inorder(TreeNode CurrentNode) { // 왼쪽 먼저 내려가서 시작(1부터) 이러면 오름차순.
		if (CurrentNode != null) {
			inorder(CurrentNode.LeftChild);
			System.out.print(" " + CurrentNode.data);
			inorder(CurrentNode.RightChild);
		}
	}

	void preorder(TreeNode CurrentNode) {
		if (CurrentNode != null) {
			System.out.print(CurrentNode.data + " ");
			preorder(CurrentNode.LeftChild);
			preorder(CurrentNode.RightChild);
		}
	}

	void postorder(TreeNode CurrentNode) {
		if (CurrentNode != null) {
			postorder(CurrentNode.LeftChild); //
			postorder(CurrentNode.RightChild);
			System.out.print(CurrentNode.data + " ");
		}
	}

	boolean insert(int x) {// binary search tree를 만드는 입력 => A + B * C을 tree로 만드는 방법: 입력 해결하는 알고리즘 작성 방법을
							// 설계하여 구현
		TreeNode temp = new TreeNode(x); // 여기만 만들게 아니라 좌, 우에도 새로 생성해야 하니까. 여기서.
		TreeNode p = root; // 링크드로, 빠지지 않게끔 연결. q를 하나 더 써서.
		TreeNode q = null;
		if (p == null) { // 암것도 없을때. 새로운 data =x 를 루트로 만들어.
			root = temp; // 루트를 새로 만들어야지.
			return true;
		}
		while (p != null) {
			q = p; //이전거 q. 그러니 부모? 가 p가 되게끔.
			if (x < p.data) { //p 데이터보다 삽입하려는게 작은수라면 왼쪽으로 가야지
				p = p.LeftChild;
				if (p == null) { //근데 삽입 할라니까 왼쪽이 비어있네? 그럼 새로 만들어야지. temp.
					q.LeftChild = temp; // 새로 생성을 해야지.
					return true;
				}
			} else if (x > p.data) {
				p = p.RightChild;
				if (p == null) {
					q.RightChild = temp; // 새로 생성을 해야지.
					return true;
				}
			}
		}
		return false;
	}

	boolean delete(int num) {
		TreeNode p = root; //루트에서부터 출발 해보자잉
		TreeNode q = root;
		boolean isLeftChild = true;
		
		while(p.data != num) {
			q = p;
			if (p.data > num) {
				isLeftChild = true;
				p = p.LeftChild;
			}
			else if (p.data < num) {
				isLeftChild = false;
				p = p.RightChild;
			}
			if (p == null) {
				return false;
			}
		}
			
		//케이스 1 : leaf node 삭제		
		if (p.LeftChild == null && p.RightChild == null) {
			if (p == root) {
				root = null;
			}
			if(isLeftChild) { //위 while에서 true를 해놨으니까...
				q.LeftChild = null; //p의 부모가 q인 상태. p는 q의 왼쪽아이. 그래서 q의 왼쪽아이를 자르면 삭제되겠네
			}
			else {
				q.RightChild = null;
			}
			
		}
		
		//케이스 2 : child 가 1개인 노드 삭제 //위랑 똑같이 하면 되겠네.
		if(p.RightChild == null) {
			if (p == root) {
				root = p.LeftChild;	//p.left?				
			}
			if(isLeftChild) { 
				q.LeftChild = p.LeftChild; //p.left? 이게 1번. 1이 부모의 왼쪽에 있는애
			}
			else {
				q.RightChild = p.LeftChild; //이게 4번. 4가 부모의 오른쪽에 있는 애.
			}
			
		}
		if(p.LeftChild == null) {
			if (p == root) {
				root = p.RightChild;	//p.left?				
			}
			if(isLeftChild) { 
				q.LeftChild = p.RightChild; //p.left?
			}
			else {
				q.RightChild = p.RightChild;
			}
			
		}		
		
		//케이스 3 : child 가 2개인 노드 삭제
		
		
		return false;
	}

	boolean search(int num) {
		TreeNode p = root;
		while (p != null) {
			if (p.data == num) {
				return true;
			} else if (p.data > num) {
				p = p.LeftChild;
			} else if (p.data < num) {
				p = p.RightChild;
			}
		}
		return false;
	}
}

public class Chap9_Test_BinaryTreeInt {	
	enum Menu { //이넘 타입은 다 이런 보라색으로 표시된다.
		Add("삽입"), Delete("삭제"), Search("검색"), InorderPrint("순차출력"), Exit("종료");

		private final String message; // 표시할 문자열

		static Menu MenuAt(int idx) { // 순서가 idx번째인 열거를 반환
			for (Menu m : Menu.values())
				if (m.ordinal() == idx) //ordinal은 enum의 메소드. 정수값으로 반환. Add의 ordinal은 0을 반환. 순서를 알수있다.
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
		Random rand = new Random();
		Scanner stdIn = new Scanner(System.in);
		Tree t = new Tree();
		Menu menu; // 메뉴
		int count = 0;
		int num;
		boolean result;
		do {
			switch (menu = SelectMenu()) {
			case Add: // 노드 삽입
				System.out.println("The number of items = ");
				count = stdIn.nextInt();
				int[] input = new int[10];
				for (int ix = 0; ix < count; ix++) {
					input[ix] = rand.nextInt(20);
				}
				for (int i = 0; i < count; i++) {
					if (t.insert(input[i]) == false)
						System.out.println("Insert Duplicated data");
				}
				break;

			case Delete: // 노드 삭제
				System.out.println("삭제할 데이터:: ");
				num = stdIn.nextInt();
				if (t.delete(num) == true)
					System.out.println("삭제 데이터 = " + num + " 성공");
				else
					System.out.println("삭제 실패");
				;
				break;

			case Search: // 노드 검색
				System.out.println("검색할 데이터:: ");

				num = stdIn.nextInt();
				result = t.search(num);
				if (result == true)
					System.out.println(" 데이터 = " + num + "존재합니다.");
				else
					System.out.println("해당 데이터가 없습니다.");
				break;

			case InorderPrint: // 전체 노드를 키값의 오름차순으로 표시
				t.inorder();
				System.out.println();
				break;
			}
		} while (menu != Menu.Exit);
	}
}
