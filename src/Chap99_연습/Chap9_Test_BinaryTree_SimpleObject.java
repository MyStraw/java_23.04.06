package Chap99_연습;
/*
 * 23.6.7 3회차 실습코드 
 */
import java.util.Comparator;
import java.util.Scanner;


class SimpleObject4 {
	static final int NO = 1; // 번호를 읽어 들일까요?
	static final int NAME = 2; // 이름을 읽어 들일까요?

	private String no; // 회원번호
	private String name; // 이름

	// --- 문자열 표현을 반환 ---//
	public String toString() {
		return "(" + no + ") " + name;
	}
	public SimpleObject4() {
		no = null;name = null;
	}
	public SimpleObject4(String no, String name) {
		this.no = no;this.name = name;
	}
	// --- 데이터를 읽어 들임 ---//
	void scanData(String guide, int sw) {
		Scanner sc = new Scanner(System.in);
		System.out.println(guide + "할 데이터를 입력하세요."+ sw);

		if ((sw & NO) == NO) { //& 는 bit 연산자임 
			System.out.print("번호: ");
			no = sc.next();
		}
		if ((sw & NAME) == NAME) {
			System.out.print("이름: ");
			name = sc.next();
		}
	}

	// --- 회원번호로 순서를 매기는 comparator ---//
	public static final Comparator<SimpleObject4> NO_ORDER = new NoOrderComparator();

	private static class NoOrderComparator implements Comparator<SimpleObject4> {
		public int compare(SimpleObject4 d1, SimpleObject4 d2) {
			return (d1.no.compareTo(d2.no) > 0) ? 1 : (d1.no.compareTo(d2.no)<0) ? -1 : 0;
		}
	}

	// --- 이름으로 순서를 매기는 comparator ---//
	public static final Comparator<SimpleObject4> NAME_ORDER = new NameOrderComparator();

	private static class NameOrderComparator implements Comparator<SimpleObject4> {
		public int compare(SimpleObject4 d1, SimpleObject4 d2) {
			return d1.name.compareTo(d2.name);
		}
	}
}


//정수를 저정하는 이진트리 만들기 실습
class TreeNode4 {
	TreeNode4 LeftChild;
	SimpleObject4 data;
	TreeNode4 RightChild;

	public TreeNode4() {
		LeftChild = RightChild = null;
	}

	TreeNode4(SimpleObject4 so) {
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

	TreeNode4 findParent(TreeNode4 current, Comparator<? super SimpleObject4> c) {
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

	public boolean add(SimpleObject4 obj, Comparator<? super SimpleObject4> c) {
		  TreeNode4 newNode = new TreeNode4(obj);
		    
		    if(root == null) {
		        root = newNode;
		        return true;
		    }

		    TreeNode4 current = root;
		    TreeNode4 parent = null;

		    while(true) {
		        parent = current;
		        if(c.compare(obj, current.data) < 0) {
		            current = current.LeftChild;
		            if(current == null) {
		                parent.LeftChild = newNode;
		                return true;
		            }
		        } else if(c.compare(obj, current.data) > 0) {
		            current = current.RightChild;
		            if(current == null) {
		                parent.RightChild = newNode;
		                return true;
		            }
		        } else {
		            return false; // no duplicate data allowed in BST
		        }
		    }
	}

	public boolean delete(SimpleObject4 obj, Comparator<? super SimpleObject4> c) {
		 TreeNode4 parent = root;
		    TreeNode4 current = root;
		    boolean isLeftChild = false;
		    
		    while(c.compare(obj, current.data) != 0) {
		        parent = current;
		        if(c.compare(obj, current.data) < 0) {
		            isLeftChild = true;
		            current = current.LeftChild;
		        } else if(c.compare(obj, current.data) > 0) {
		            isLeftChild = false;
		            current = current.RightChild;
		        }
		        if(current == null) {
		            return false;
		        }
		    }
		    
		    if(current.LeftChild == null && current.RightChild == null) {
		        if(current == root) {
		            root = null;
		        }
		        if(isLeftChild) {
		            parent.LeftChild = null;
		        } else {
		            parent.RightChild = null;
		        }
		    } else if(current.RightChild == null) {
		        if(current == root) {
		            root = current.LeftChild;
		        } else if(isLeftChild) {
		            parent.LeftChild = current.LeftChild;
		        } else {
		            parent.RightChild = current.LeftChild;
		        }
		    } else if(current.LeftChild == null) {
		        if(current == root) {
		            root = current.RightChild;
		        } else if(isLeftChild) {
		            parent.LeftChild = current.RightChild;
		        } else {
		            parent.RightChild = current.RightChild;
		        }
		    } else {
		        TreeNode4 successor = inorderSucc(current);
		        if(current == root) {
		            root = successor;
		        } else if(isLeftChild) {
		            parent.LeftChild = successor;
		        } else {
		            parent.RightChild = successor;
		        } 
		        successor.LeftChild = current.LeftChild;
		    }
		    return true;

	}

	boolean search(SimpleObject4 obj, Comparator<? super SimpleObject4> c) {
	    TreeNode4 current = root;
	    while(current != null) {
	        if(c.compare(obj, current.data) == 0) {
	            return true;
	        } else if(c.compare(obj, current.data) < 0) {
	            current = current.LeftChild;
	        } else {
	            current = current.RightChild;
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
		SimpleObject4 so;
		int count = 0;
		int num;
		boolean result;
		do {
			switch (menu = SelectMenu()) {
			case Add: // 머리노드 삽입
				SimpleObject4[] sox = { new SimpleObject4("33", "ee"), new SimpleObject4("55", "tt"),
						new SimpleObject4("22", "ww"), new SimpleObject4("66", "yy"), new SimpleObject4("21", "wq") };
				for (SimpleObject4 soz : sox)
					t.add(soz, SimpleObject4.NO_ORDER);
				break;
			case Delete: // 머리 노드 삭제
           	 so = new SimpleObject4();
           	 so.scanData("삭제", SimpleObject4.NO);
           	 t.delete(so, SimpleObject4.NO_ORDER);
	
				break;
			case Search: // 회원 번호 검색
	           	 so = new SimpleObject4();
	           	 so.scanData("검색", SimpleObject4.NO);
				result = t.search(so, SimpleObject4.NO_ORDER);
				if (result == false)
					System.out.println("검색 값 = " + so + "데이터가 없습니다.");
				else
					System.out.println("검색 값 = " + so + "데이터가 존재합니다.");
				break;

			case InorderPrint: // 전체 노드를 키값의 오름차순으로 표시
				t.inorder();
				break;
			case Exit:
				break;
			}
		} while (menu != Menu.Exit);
	}
}
