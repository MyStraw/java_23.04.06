package Chap5_재귀알고리즘;

import java.util.Scanner;
import java.util.Stack;

class EmptyIntStackException extends RuntimeException { // 사용자정의 예외.
	public EmptyIntStackException() { // 생성자 객체를 쓰겠다
	}
}

// --- 실행시 예외: 스택이 가득 참 ---//
class OverflowIntStackException extends RuntimeException {
	public OverflowIntStackException() {
	}
}

class IntStack {
	private int[] data; // 스택용 배열
	private int capacity; // 스택의 크기
	private int top; // 스택 포인터

	public IntStack(int i) {
		top = 0;
		capacity = i;
		try {
			data = new int[capacity]; // 스택 본체용 배열을 생성
		} catch (OutOfMemoryError e) { // 생성할 수 없음
			capacity = 0;
		}
	}

// --- 스택에 x를 푸시 ---//
	public int push(int x) throws OverflowIntStackException {
		if (top >= capacity) // 스택이 가득 참
			throw new OverflowIntStackException(); // 생성자 통해 객체 만들어서 던져. 가득차면 overflow 예외로 간다.
		return data[top++] = x; // 넣고 플러스
	}

// --- 스택에서 데이터를 팝(정상에 있는 데이터를 꺼냄) ---//
	public int pop() throws EmptyIntStackException {//
		if (top <= 0) // 스택이 빔
			throw new EmptyIntStackException();
		return data[--top]; // top 앞에 하나 빼고 가져오고
	}

// --- 스택에서 데이터를 피크(peek, 정상에 있는 데이터를 들여다봄) ---//
	public int peek() throws EmptyIntStackException {
		if (top <= 0) // 스택이 빔
			throw new EmptyIntStackException();
		return data[top - 1];
	}

// --- 스택을 비움 ---//
	public void clear() {
		top = 0;
	}

// --- 스택에서 x를 찾아 인덱스(없으면 –1)를 반환 ---//
	public int indexOf(int x) {
		for (int i = top - 1; i >= 0; i--) // 꼭대기 쪽부터 선형 검색
			if (data[i] == x)
				return i; // 검색 성공
		return -1; // 검색 실패
	}

// --- 스택의 크기를 반환 ---//
	public int getCapacity() {
		return capacity;
	}

// --- 스택에 쌓여있는 데이터 갯수를 반환 ---//
	public int size() {
		return top;
	}

// --- 스택이 비어있는가? ---//
	public boolean isEmpty() {
		return top <= 0;
	}

// --- 스택이 가득 찼는가? ---//
	public boolean isFull() {
		return top >= capacity;
	}

// --- 스택 안의 모든 데이터를 바닥 → 정상 순서로 표시 ---//
	public void dump() {
		if (top <= 0)
			System.out.println("스택이 비어있습니다.");
		else {
			for (int i = 0; i < top; i++)
				System.out.print(data[i] + " ");
			System.out.println();
		}
	}
}

class RecurX2 {

	static void recur(int n) {
		IntStack s = new IntStack(n);
	//	Stack<Integer> st = new Stack<>(); // 그냥 이거 이용

		while (true) { // 추가
			if (n > 0) {
				System.out.println("recur(" + n + "-1);");

				try {
					s.push(n);
				} catch (OverflowIntStackException e) {
					System.out.println("스택이 가득찼습니다.");
				}
				n = n - 1;
				// recur(n - 1);
				continue;
			}
			if (s.isEmpty() != true) {

				try {
					n = s.pop();
				} catch (EmptyIntStackException e) {
					System.out.println("스택이 비었습니다.");
				}
				System.out.println(n);
				System.out.println("recur(" + n + "-2);");
				// recur(n - 2);
				n = n - 2;
				continue;

			}
			break;

		}
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.println("정수를 입력하세요.: ");
		int x = stdIn.nextInt();

		recur(x);
	}

}
