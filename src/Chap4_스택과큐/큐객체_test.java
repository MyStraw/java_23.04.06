package Chap4_스택과큐;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

//int형 고정 길이 큐
class EmptyGenericQueueException extends RuntimeException {
	public EmptyGenericQueueException() { //위로빼면서 class로 해준거구나
	}
}

class OverflowGenericQueueException extends RuntimeException {
	public OverflowGenericQueueException() {
	}
}

//int형 고정 길이 큐
class objectQueue {
	private List<Point> que;
	private int capacity; // 큐의 크기
	private int front; // 맨 처음 요소 커서
	private int rear; // 맨 끝 요소 커서
	private int num; // 현재 데이터 개수

	// ---생성자
	public objectQueue(int i) {
		num = front = rear = 0;
		capacity = i;
		try {
			que = new ArrayList<Point>(); // 큐 본체용 배열을 생성
		} catch (OutOfMemoryError e) { // 생성할 수 없음
			capacity = 0;
		}
	}

	// --- 큐에 데이터를 인큐 ---//
	public int enque(Point x) throws OverflowGenericQueueException {
		if (num >= capacity)
			throw new OverflowGenericQueueException(); // 큐가 가득 찼음
		que.add(x);
		num++;
		if (rear == capacity)
			rear = 0;
		return 1;
	}

	// --- 큐에서 데이터를 디큐 ---//
	public Point deque() throws EmptyGenericQueueException {
		if (num <= 0)
			throw new EmptyGenericQueueException(); // 큐가 비어있음
		Point x = que.remove(front);
		num--;
		if (front == capacity)
			front = 0;
		return x;
	}

	// --- 큐에서 데이터를 피크(프런트 데이터를 들여다봄) ---//
	public Point peek() throws EmptyGenericQueueException {
		if (num <= 0)
			throw new EmptyGenericQueueException(); // 큐가 비어있음
		return que.get(front);
	}

	// --- 큐를 비움 ---//
	public void clear() {
		num = front = rear = 0;
	}

	// --- 큐에서 x를 검색하여 인덱스(찾지 못하면 –1)를 반환 ---//
	public int indexOf(int x) {
		for (int i = 0; i < num; i++) {
			int idx = (i + front) % capacity;
			if (que.get(idx).equals(x)) // 검색 성공
				return idx;
		}
		return -1; // 검색 실패
	}

	// --- 큐의 크기를 반환 ---//
	public int getCapacity() {
		return capacity;
	}

	// --- 큐에 쌓여 있는 데이터 개수를 반환 ---//
	public int size() {
		return num;
	}

	// --- 큐가 비어있는가? ---//
	public boolean isEmpty() {
		return num <= 0;
	}

	// --- 큐가 가득 찼는가? ---//
	public boolean isFull() {
		return num >= capacity;
	}

	// --- 큐 안의 모든 데이터를 프런트 → 리어 순으로 출력 ---//
	public void dump() {
		if (num <= 0)
			System.out.println("큐가 비어있습니다.");
		else {
			for (int i = 0; i < num; i++)
				System.out.print(que.get((i + front) % capacity).toString() + " ");
			System.out.println();
		}
	}

}

//int형 고정 길이 큐의 사용 예
public class 큐객체_test {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		objectQueue s = new objectQueue(4); // 최대 64개를 인큐할 수 있는 큐
		Random random = new Random();
		int rndx = 0, rndy = 0;
		Point p = null;
		while (true) {
			System.out.println(" "); // 메뉴 구분을 위한 빈 행 추가
			System.out.printf("현재 데이터 개수: %d / %d\n", s.size(), s.getCapacity());
			System.out.print("(1)인큐　(2)디큐　(3)피크　(4)덤프　(0)종료: ");

			int menu = stdIn.nextInt();
			if (menu == 0)
				break;

			int x;
			switch (menu) {
			case 1: // 인큐
				System.out.print("데이터: ");
				rndx = random.nextInt() % 20;
				rndy = random.nextInt() % 20;
				p = new Point(rndx, rndy);
				try {
					s.enque(p);
				} catch (OverflowGenericQueueException e) {
					System.out.println("stack이 가득찼있습니다.");
				}
				break;

			case 2: // 디큐
				try {
					p = s.deque();
					System.out.println("디큐한 데이터는 " + p + "입니다.");
				} catch (EmptyGenericQueueException e) {
					System.out.println("큐가 비어 있습니다.");
				}
				break;

			case 3: // 피크
				try {
					p = s.peek();
					System.out.println("피크한 데이터는 " + p + "입니다.");
				} catch (EmptyGenericQueueException e) {
					System.out.println("큐가 비어 있습니다.");
				}
				break;

			case 4: // 덤프
				s.dump();
				break;
			}
		}
	}
}