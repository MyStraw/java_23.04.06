package Chap4_스택과큐;

import java.util.Scanner;

// int형 고정 길이 스택

class EmptyIntStackException extends RuntimeException { // 사용자정의 예외.
	public EmptyIntStackException() { // 생성자
	}
}

// --- 실행시 예외: 스택이 가득 참 ---//
class OverflowIntStackException extends RuntimeException {
	public OverflowIntStackException() {
	}
}

class IntStackTest {
	private int[] stk; // 스택용 배열
	private int capacity; // 스택의 크기
	private int ptr; // 스택 포인터

	// --- 실행시 예외: 스택이 비어있음 ---//

	// --- 생성자(constructor) ---//
	public IntStackTest(int maxlen) {
		ptr = 0;
		capacity = maxlen;
		try {
			stk = new int[capacity]; // 스택 본체용 배열을 생성
		} catch (OutOfMemoryError e) { // 생성할 수 없음
			capacity = 0;
		}
	}

	// --- 스택에 x를 푸시 ---//
	public int push(int x) throws OverflowIntStackException {
		if (ptr >= capacity) // 스택이 가득 참
			throw new OverflowIntStackException(); // 생성자 통해 객체 만들어서 던져. 가득차면 overflow 예외로 간다.
		return stk[ptr++] = x; // 넣고 플러스
	}

	// --- 스택에서 데이터를 팝(정상에 있는 데이터를 꺼냄) ---//
	public int pop() throws EmptyIntStackException {//
		if (ptr <= 0) // 스택이 빔
			throw new EmptyIntStackException();
		return stk[--ptr]; // ptr 앞에 하나 빼고 가져오고
	}

	// --- 스택에서 데이터를 피크(peek, 정상에 있는 데이터를 들여다봄) ---//
	public int peek() throws EmptyIntStackException {
		if (ptr <= 0) // 스택이 빔
			throw new EmptyIntStackException();
		return stk[ptr - 1];
	}

	// --- 스택을 비움 ---//
	public void clear() {
		ptr = 0;
	}

	// --- 스택에서 x를 찾아 인덱스(없으면 –1)를 반환 ---//
	public int indexOf(int x) {
		for (int i = ptr - 1; i >= 0; i--) // 꼭대기 쪽부터 선형 검색
			if (stk[i] == x)
				return i; // 검색 성공
		return -1; // 검색 실패
	}

	// --- 스택의 크기를 반환 ---//
	public int getCapacity() {
		return capacity;
	}

	// --- 스택에 쌓여있는 데이터 갯수를 반환 ---//
	public int size() {
		return ptr;
	}

	// --- 스택이 비어있는가? ---//
	public boolean isEmpty() {
		return ptr <= 0; // 0보다 작거나 같으면 트루.
	}

	// --- 스택 안의 모든 데이터를 바닥 → 정상 순서로 표시 ---//
	public void dump() {
		if (isEmpty()) // isEmpty 만들었으니 밑에꺼 안쓰고 이걸로. 이런 큰 범주를 쓰는 연습.
			// if (ptr <= 0)
			System.out.println("스택이 비어있습니다.");
		else {
			for (int i = 0; i < ptr; i++)
				System.out.print(stk[i] + " ");
			System.out.println();
		}
	}
}

public class 스택정수 {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		IntStackTest s = new IntStackTest(8); // 최대 64 개를 푸시할 수 있는 스택

		while (true) {
			System.out.println(); // 메뉴 구분을 위한 빈 행 추가
			System.out.printf("현재 데이터 개수: %d / %d\n", s.size(), s.getCapacity());
			System.out.print("(1)푸시　(2)팝　(3)피크　(4)덤프　(0)종료: ");

			int menu = stdIn.nextInt();
			if (menu == 0)
				break;

			int x;
			switch (menu) {
			case 1: // 푸시
				System.out.print("데이터: ");
				x = stdIn.nextInt();
				try {
					s.push(x);
				} catch (OverflowIntStackException e) {
					System.out.println("스택이 가득 찼습니다.");
				}
				break;

			case 2: // 팝
				try {
					x = s.pop();
					System.out.println("팝한 데이터는 " + x + "입니다.");
				} catch (EmptyIntStackException e) {
					System.out.println("스택이 비어있습니다.");
				}
				break;

			case 3: // 피크
				try {
					x = s.peek();
					System.out.println("피크한 데이터는 " + x + "입니다.");
				} catch (EmptyIntStackException e) {
					System.out.println("스택이 비어있습니다.");
				}
				break;

			case 4: // 덤프
				s.dump();
				break;
			}
		}
	}
}
