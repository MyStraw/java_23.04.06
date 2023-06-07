package Chap99_연습;

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
}

class Tree {
	TreeNode root;

	Tree() {
		root = null;
	}

	TreeNode inorderSucc(TreeNode current) {
		TreeNode temp = current.RightChild;
		if (current.RightChild != null)
			while (temp.LeftChild != null)
				temp = temp.LeftChild;
		return temp;
	}

	boolean isLeafNode(TreeNode current) {
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

	void inorder(TreeNode CurrentNode) {
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
			postorder(CurrentNode.LeftChild);
			postorder(CurrentNode.RightChild);
			System.out.print(CurrentNode.data + " ");
		}
	}

	boolean insert(int x) {// binary search tree를 만드는 입력 => A + B * C을 tree로 만드는 방법: 입력 해결하는 알고리즘 작성 방법을
							// 설계하여 구현
		TreeNode newNode = new TreeNode();
		newNode.data = x;

		if (root == null) {
			root = newNode;
			return true;
		}

		TreeNode current = root;
		TreeNode parent = null;

		while (true) {
			parent = current;
			if (x < current.data) {
				current = current.LeftChild;
				if (current == null) {
					parent.LeftChild = newNode;
					return true;
				}
			} else if (x > current.data) {
				current = current.RightChild;
				if (current == null) {
					parent.RightChild = newNode;
					return true;
				}
			} else {
				return false; // no duplicate data allowed in BST
			}
		}
	}

	boolean delete(int num) {
		TreeNode parent = root;
		TreeNode current = root;
		boolean isLeftChild = false;

		while (current.data != num) {
			parent = current;
			if (current.data > num) {
				isLeftChild = true;
				current = current.LeftChild;
			} else if (current.data < num) {
				isLeftChild = false;
				current = current.RightChild;
			}
			if (current == null) {
				return false;
			}
		}

		// Case 1: if node to be deleted has no children
		if (current.LeftChild == null && current.RightChild == null) {
			if (current == root) {
				root = null;
			}
			if (isLeftChild) {
				parent.LeftChild = null;
			} else {
				parent.RightChild = null;
			}
		}
		// Case 2 : if node to be deleted has only one child
		else if (current.RightChild == null) {
			if (current == root) {
				root = current.LeftChild;
			} else if (isLeftChild) {
				parent.LeftChild = current.LeftChild;
			} else {
				parent.RightChild = current.LeftChild;
			}
		} else if (current.LeftChild == null) {
			if (current == root) {
				root = current.RightChild;
			} else if (isLeftChild) {
				parent.LeftChild = current.RightChild;
			} else {
				parent.RightChild = current.RightChild;
			}
		}
		// Case 3: node to be deleted has two children
		else {
			TreeNode successor = inorderSucc(current);
			if (current == root) {
				root = successor;
			} else if (isLeftChild) {
				parent.LeftChild = successor;
			} else {
				parent.RightChild = successor;
			}
			successor.LeftChild = current.LeftChild;
		}
		return true;

	}

	boolean search(int num) {
		TreeNode current = root;
		while (current != null) {
			if (current.data == num) {
				return true;
			} else if (current.data > num) {
				current = current.LeftChild;
			} else {
				current = current.RightChild;
			}
		}
		return false;
	}
}

public class Chap9_Test_BinaryTreeInt {
	enum Menu {
		Add("삽입"), Delete("삭제"), Search("검색"), InorderPrint("순차출력"), Exit("종료");

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
