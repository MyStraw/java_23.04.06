package _스터디_자료구조;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

//import static _스터디_자료구조._4_1_버블정렬.bubbleSort1;
import static _스터디_자료구조._4_1_버블정렬.bubbleSort2;
import static _스터디_자료구조._4_1_버블정렬.bubbleSort3;
import static _스터디_자료구조._4_2_단순선택정렬.selectionSort;
import static _스터디_자료구조._4_3_단순삽입정렬.insertionSort;
import static _스터디_자료구조._4_4_셸정렬.shellSort1;
import static _스터디_자료구조._4_4_셸정렬.shellSort2;

public class _4_0_menu {
	public static boolean upOrdown = true;
	public static int count = 0;
	public static final int num = 9;

	enum Menu {
		Bubble1("버블1"), Bubble2("버블2"), Bubble3("버블3"), Selection("선택"), Insertion("삽입"), Shell1("쉘1"), Shell2("쉘2"),
		Exit("종료");

		private final String message;

		static Menu MenuAt(int index) {
			for (Menu m : Menu.values()) {
				if (m.ordinal() == index) {
					return m;
				}
			}
			return null;
		}

		Menu(String string) {
			message = string;
		}

		String getMessage() {
			return message;
		}
	}

	static Menu SelectMenu() {
		Scanner sc = new Scanner(System.in);
		int key;
		do {
			for (Menu m : Menu.values()) {
				System.out.printf("(%d) %s  ", m.ordinal() + 1, m.getMessage());
				if ((m.ordinal() % 6) == 3 && m.ordinal() != Menu.Exit.ordinal())
					System.out.println();
			}
			System.out.print(" : ");
			key = sc.nextInt() - 1;
		} while (key < Menu.Bubble1.ordinal() || key > Menu.Exit.ordinal());
		return Menu.MenuAt(key);
	}

	public static void main(String[] args) {		
		Random rd = new Random();
		Set<Integer> noDuplicate = new HashSet<>();
		System.out.println("정렬 알고리즘");
		int dataSize = num;
		int[] sort = new int[dataSize];

		long startTime = System.currentTimeMillis();
		long startMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

		for (int i = 0; i < dataSize;) { // 여기서 i++를 하지 않는다.
			int randomNum = rd.nextInt(num) + 1;
			if (noDuplicate.add(randomNum)) {
				sort[i] = randomNum;
				System.out.print("bubble[" + i + "]: ");
				System.out.println(sort[i]);
				i++;
			}
		}
		Menu menu;
		System.out.println();
		//Scanner sc = new Scanner(System.in);
		do {
			switch (menu = SelectMenu()) {
			case Bubble1:
				System.out.println();
				System.out.println("버블정렬 버전1");
				_4_1_버블정렬 sorter = new _4_1_버블정렬(); //static으로 해놨으니 객체생성 안해도 된다.
				//_4_1_버블정렬.bubbleSort1(sort, dataSize); // static이 있으면 이걸 쓰면 되지. 왜 계속 노란줄 그이나 했넹.
				sorter.bubbleSort1(sort, dataSize); //그래서 여기에 노란색 줄이 그인다. bubbleSort1의 static을 없애면 됨
				for (int i = 0; i < dataSize; i++) {
					System.out.print("bubble[" + i + "]: ");
					System.out.println(sort[i]);
				}
				long endTime = System.currentTimeMillis();
				long endMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
				System.out.println();
				System.out.println("실행시간 : " + (endTime - startTime) + " ms");
				System.out.println("메모리 사용량 : " + (endMemory - startMemory) / 1024.0 + " KB");
				System.out.println("교환회수 : " + count);
				System.out.println();
				break;
			}
		} while (menu != Menu.Exit);

	}

}
