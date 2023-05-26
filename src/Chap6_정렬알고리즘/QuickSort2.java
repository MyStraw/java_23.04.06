package Chap6_정렬알고리즘;
//퀵 정렬(비재귀 버전)

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import Chap4_스택과큐.IntStack_book.EmptyIntStackException;
import Chap4_스택과큐.IntStack_book.OverflowIntStackException;

class EmptyGenericStackException extends RuntimeException { // 사용자정의 예외.
	public EmptyGenericStackException() { // 생성자
	}
}

// --- 실행시 예외: 스택이 가득 참 ---//
class OverflowGenericStackException extends RuntimeException {
	public OverflowGenericStackException() {
	}
}

class ObjectStack {
	private List<Point> data; // 스택용 배열
	private int capacity; // 스택의 크기
	private int top; // 스택 포인터

	public ObjectStack(int maxlen) {
		top = 0;
		capacity = maxlen;
		try {
			data = new ArrayList<Point>();
		} catch (OutOfMemoryError e) {
			capacity = 0;
		}
	}

	public int push(Point x) throws OverflowGenericStackException {
		if (top >= capacity)
			throw new OverflowGenericStackException();
		data.add(x);
		top++;
		return 1;

	}

	public Point pop() throws EmptyGenericStackException {//
		if (top <= 0)
			throw new EmptyGenericStackException();
		{
			// Point p = data.get(top - 1);
			Point p = data.remove(top - 1); // 팝은 끄집어 내는거. 그럼 겟이 아니라 리무브가 맞다.
			top--;
			return p;

		}

	}

	public Point peek() throws EmptyIntStackException { // 꼭대기는 값을 줘야하니 int가 아니라 Point
		if (top <= 0) // 스택이 빔
			throw new EmptyGenericStackException();
		// return stk[ptr - 1];
		return data.get(top - 1);
	}

	// --- 스택을 비움 ---//
	public void clear() {
		top = 0;
	}

	// --- 스택에서 x를 찾아 인덱스(없으면 –1)를 반환 ---//
	public int indexOf(Point x) {
		for (int i = top - 1; i >= 0; i--) // 꼭대기 쪽부터 선형 검색
			if (data.get(i).equals(x))
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
				System.out.print(data.get(i) + " ");
			System.out.println();
		}
	}

}

class Point {
	private int x;
	private int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]"; // x,y 컴마컴이니까~
	}

	@Override
	public boolean equals(Object p) { // Object 클래스에 존재하는 equals()메소드가 정의되어 있는데 오버라이드 하려면 파라미터가 같아야 한다.(객체)
										// (Point P) 라고 입력하니까 @Override 떼라고 에러떠. 이건 객체가 아니니 (Object p) 이걸로 바꾸면
		Point px = (Point) p; // 아래에 그냥 x.x 하니까 없는 필드래. Point에는 x가 없으니까.
		if (this.x == px.x && this.y == px.y)
			return true;
		else
			return false;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}

class QuickSort2 {
	// --- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//

	static int count = 0;

	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}

	// --- 퀵 정렬(비재귀 버전)---//
	static void quickSort2(int[] a, int left, int right) {
		ObjectStack st = new ObjectStack(right - left + 1);
		Point p = new Point(left, right);
		try {
			st.push(p);

		} catch (OverflowIntStackException e) {
			System.out.println("스택이 가득찼습니다");
		}

		// st.push(p);

		while (st.isEmpty() != true) {
			p = st.pop();
			int pl = left = p.getX(); // 왼쪽 커서
			int pr = right = p.getY(); // 오른쪽 커서
			int x = a[(left + right) / 2]; // 피벗은 가운데 요소

			do {
				while (a[pl] < x) {
					pl++;
					count++;
				}
				while (a[pr] > x) {
					pr--;
					count++;
				}
				if (pl <= pr)
					swap(a, pl++, pr--);
				count++;
			} while (pl <= pr);

			if (left < pr) {
				p = new Point(left, pr);
				st.push(p); // 왼쪽 그룹 범위의
							// 인덱스를 푸시
			}
			if (pl < right) {
				p = new Point(pl, right);
				st.push(p); // 오른쪽 그룹 범위의
				// 인덱스를 푸시
			}
		}
		System.out.println("\n\n비교횟수 = " + count);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		System.out.println("퀵 정렬");
		System.out.print("요솟수: ");
		int nx = sc.nextInt();
		int[] x = new int[nx];

		for (int i = 0; i < nx; i++) {
			System.out.print("x[" + i + "]: ");
			x[i] = random.nextInt(100);
		}

		quickSort2(x, 0, nx - 1); // 배열 x를 퀵정렬

		System.out.println("오름차순으로 정렬했습니다.");
		for (int i = 0; i < nx; i++)
			System.out.println("x[" + i + "]=" + x[i]);
	}
}
