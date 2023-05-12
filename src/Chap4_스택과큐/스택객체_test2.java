// 사용자 정의 예외 클래스 EmptyIntStackException을 정의합니다.
// 이 예외는 스택이 비어있을 때 발생합니다.
class EmptyIntStackException extends RuntimeException {
	public EmptyIntStackException() {
	}
}

// 사용자 정의 예외 클래스 OverflowIntStackException을 정의합니다.
// 이 예외는 스택이 가득 찼을 때 발생합니다.
class OverflowIntStackException extends RuntimeException {
	public OverflowIntStackException() {
	}
}

// IntStack 클래스를 정의합니다. 이 클래스는 정수 스택을 구현합니다.
class IntStack {
	private int[] data; // 스택용 배열
	private int capacity; // 스택의 크기
	private int top; // 스택 포인터

	// IntStack 클래스의 생성자를 정의합니다. 스택 크기를 매개변수로 받아, 스택 본체용 배열을 생성합니다.
	public IntStack(int i) {
		top = 0;
		capacity = i;
		try {
			data = new int[capacity]; // 스택 본체용 배열을 생성
		} catch (OutOfMemoryError e) { // 생성할 수 없음
			capacity = 0;
		}
	}

	// push 메소드를 정의합니다. 스택에 정수를 추가하고, 스택이 가득 찼을 때 OverflowIntStackException 예외를
	// 발생시킵니다.
	public int push(int x) throws OverflowIntStackException {
		if (top >= capacity) // 스택이 가득 참
			throw new OverflowIntStackException(); // 생성자 통해 객체 만들어서 던져. 가득차면 overflow 예외로 간다.
		return data[top++] = x; // 넣고 플러스
	}

	// pop 메소드를 정의합니다. 스택에서 데이터를 꺼내 반환하며, 스택이 비어있을 때 EmptyIntStackException 예외를
	// 발생시킵니다.
	public int pop() throws EmptyIntStackException {
		if (top <= 0) // 스택이 빔
			throw new EmptyIntStackException();
		return data[--top]; // top 앞에 하나 빼고 가져오고
	}

	// peek 메소드를 정의합니다. 스택의 정상에 있는 데이터를 반환하며, 스택이 비어있을 때 EmptyIntStackException 예외를
	// 발생시킵니다.
	public int peek() throws EmptyIntStackException {
		if (top <= 0) // 스택이 빔
			throw new EmptyIntStackException();
		return data[top - 1];
	}

	// clear 메소드를 정의합니다. 스택의 모든 데이터를 삭제합니다.
	public void clear() {
		top = 0;
	}

	// indexOf 메소드를 정의합니다. 스택에서 특정 데이터를 찾아 인덱스를 반환하고
	// 데이터가 없을 경우 -1을 반환합니다.
	public int indexOf(int x) {
		for (int i = top - 1; i >= 0; i--) // 꼭대기 쪽부터 선형 검색
			if (data[i] == x)
				return i; // 검색 성공
		return -1; // 검색 실패
	}

	// getCapacity 메소드를 정의합니다. 스택의 크기를 반환합니다.
	public int getCapacity() {
		return capacity;
	}

	// size 메소드를 정의합니다. 스택에 쌓여있는 데이터 개수를 반환합니다.
	public int size() {
		return top;
	}

	// isEmpty 메소드를 정의합니다. 스택이 비어있는지 확인하여 빈 경우 true를 반환합니다.
	public boolean isEmpty() {
		return top <= 0;
	}

	// isFull 메소드를 정의합니다. 스택이 가득 찼는지 확인하여 가득 찬 경우 true를 반환합니다.
	public boolean isFull() {
		return top >= capacity;
	}

	// dump 메소드를 정의합니다. 스택 안의 모든 데이터를 바닥에서 정상 순서로 출력합니다. 스택이 비어있는 경우, "스택이
	// 비어있습니다."라고 출력합니다.
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

// 스택정수_test 클래스를 정의합니다. 이 클래스는 IntStack 클래스를 사용하여 테스트를 수행하는 메인 클래스입니다.
public class 스택정수_test2 {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		IntStack s = new IntStack(4); // 최대 64 개를 푸시할 수 있는 스택

		while (true) {
			System.out.println(); // 메뉴 구분을 위한 빈 행 추가
			System.out.printf("현재 데이터 개수: %d / %d\n", s.size(), s.getCapacity());
			System.out.print("(1)push　(2)pop　(3)peek　(4)dump　(0)종료: ");

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
