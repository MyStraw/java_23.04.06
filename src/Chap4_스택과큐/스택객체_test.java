package Chap4_스택과큐;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

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
		top ++;
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
			throw new EmptyIntStackException();
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
		return "Point [x=" + x + ", y=" + y + "]"; //x,y 컴마컴이니까~
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
}

public class 스택객체_test {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		ObjectStack s = new ObjectStack(8); // 최대 8 개를 push할 수 있는 stack
		Random random = new Random();
		int rndx = 0, rndy = 0;
		Point p = null;
		while (true) {
			System.out.println(); // 메뉴 구분을 위한 빈 행 추가
			System.out.printf("현재 데이터 개수: %d / %d\n", s.size(), s.getCapacity());
			System.out.print("(1)push　(2)pop　(3)peek　(4)dump　(0)종료: ");

			int menu = stdIn.nextInt();
			if (menu == 0)
				break;

			switch (menu) {
			case 1: // 푸시
				System.out.print("데이터: ");
				rndx = random.nextInt() % 20;
				rndy = random.nextInt() % 20;
				p = new Point(rndx, rndy);
				System.out.println(p);
				try {
					s.push(p);
				} catch (OverflowGenericStackException e) {
					System.out.println("stack이 가득찼있습니다.");
				}
				break;

			case 2: // 팝
				try {
					p = s.pop();
					System.out.println("pop한 데이터는 " + p + "입니다.");
				} catch (EmptyGenericStackException e) {
					System.out.println("stack이 비어있습니다.");
				}
				break;

			case 3: // 피크
				try {
					p = s.peek();
					System.out.println("peek한 데이터는 " + p + "입니다.");
				} catch (EmptyGenericStackException e) {
					System.out.println("stack이 비어있습니다.");
				}
				break;

			case 4: // 덤프
				s.dump();
				break;
			}
		}
	}
}