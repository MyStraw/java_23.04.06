package _bitcoding;

import java.util.ArrayList;
import java.util.List;

class EmptyGenericStackException extends RuntimeException { // 사용자정의 예외.
	public EmptyGenericStackException() { // 생성자
	}
}

// --- 실행시 예외: 스택이 가득 참 ---//
class OverflowGenericStackException extends RuntimeException {
	public OverflowGenericStackException() {
	}
}

class StackList {
	private List<Items> data; // 스택용 배열
	private int capacity; // 스택의 크기
	private int top; // 스택 포인터

	public StackList(int maxlen) {
		top = 0;
		capacity = maxlen;
		try {
			data = new ArrayList<Items>();
		} catch (OutOfMemoryError e) {
			capacity = 0;
		}
	}

	public int push(Items x) throws OverflowGenericStackException {
		if (top >= capacity)
			throw new OverflowGenericStackException();
		data.add(x);
		top++;
		return 1;

	}

	public Items pop() throws EmptyGenericStackException {//
		if (isEmpty())
			throw new EmptyGenericStackException();
		{
			// Point p = data.get(top - 1);
			Items p = data.remove(top - 1); // 팝은 끄집어 내는거. 그럼 겟이 아니라 리무브가 맞다.
			top--;
			return p;
		}

	}

	public Items peek() throws EmptyGenericStackException { // 꼭대기는 값을 줘야하니 int가 아니라 Point
		if (isEmpty()) // 스택이 빔
			throw new EmptyGenericStackException();
		// return stk[ptr - 1];
		return data.get(top - 1);
	}

	// --- 스택을 비움 ---//
	public void clear() {
		top = 0;
	}

	// --- 스택에서 x를 찾아 인덱스(없으면 –1)를 반환 ---//
	public int indexOf(Items x) {
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

enum Directions {
	N, NE, E, SE, S, SW, W, NW
}

class Items {
	public Items(int x, int y, int dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}

	int x;
	int y;
	int dir;

}

class Offsets {
	public Offsets(int a, int b) {
		this.a = a;
		this.b = b;
	}

	int a;
	int b;
}

public class MazingProblem_finish {
	// 만약 이 필드를 같은 패키지 내에서만 사용하려면 디폴트 접근 제어자를,
	// 다른 패키지에서도 사용하려면 'public'을,
	// 오직 같은 클래스 내에서만 사용하려면 'private'을 선택하게 될 것입니다.

	private static Offsets[] moves = new Offsets[8];// static을 선언하는 이유를 알아야 한다
	// 객체를 담는 배열
//	[][][] 이런 방을 만든거다. 여기에 생성자가 있네~
//	[]  []
//	[][][]

	public static void path(int[][] maze, int[][] mark, int ix, int iy) {

		mark[1][1] = 1;
		StackList st = new StackList(50);
		Items temp = new Items(0, 0, 0);// N :: 0
		temp.x = 1; // Items의 x
		temp.y = 1; // Items의 y
		temp.dir = 2;// E:: 2 east?
		mark[temp.x][temp.y] = 2;// 미로 찾기 궤적은 2로 표시
		st.push(temp);

		while (!st.isEmpty()) // stack not empty //backtracking
		{
			Items tmp = st.pop(); // unstack
			int i = tmp.x; // pop된 x값을 i에 넣는다.
			int j = tmp.y;
			int d = tmp.dir; // 이게 offsets 안에 들어가야할 방향인거 같다.
			mark[i][j] = 1;// backtracking 궤적은 1로 표시
//			[7][0][1] 
//			[6]   [2]
//			[5][4][3]
			while (d < 8) // moves forward
			{
				int g = i + moves[d].a; // 그다음위치
				int h = j + moves[d].b;

				if ((g == ix) && (h == iy)) { // reached exit // output path
					System.out.println(st); // output path
					System.out.println("the term near the exit: " + i + " " + j);
					System.out.println("exit: " + ix + " " + iy);
					mark[g][h] = 2;
					mark[i][j] = 2;
					while (!st.isEmpty()) {
						tmp = st.pop();
						mark[tmp.x][tmp.y] = 2;

					}
					return;
				}
				if ((maze[g][h] == 0) && (mark[g][h] == 0)) { // new position
					temp.x = i;
					temp.y = j;
					temp.dir = d + 1;
					Items push = new Items(i, j, d + 1);
					st.push(push);
					mark[temp.x][temp.y] = 1;
					i = g;
					j = h;
					d = 0;

				} else
					d++;

			}
		}
		System.out.println("no path in maze ");
	}

	public static void main(String[] args) {
		int[][] maze = new int[14][17];
		int[][] mark = new int[14][17];

		int input[][] = { // 12 x 15
				{ 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1 },
				{ 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1 }, { 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0 },
				{ 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1 }, { 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 }, { 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1 }, { 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 }, { 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0 } };

		for (int ia = 0; ia < 8; ia++) {
			moves[ia] = new Offsets(0, 0);// 배열에 offsets 객체를 치환해야 한다.
		}
		moves[0].a = -1;
		moves[0].b = 0; // ↑
		moves[1].a = -1;
		moves[1].b = 1; // ↗
		moves[2].a = 0;
		moves[2].b = 1; // →
		moves[3].a = 1;
		moves[3].b = 1; // ↘
		moves[4].a = 1;
		moves[4].b = 0; // ↓
		moves[5].a = 1;
		moves[5].b = -1; // ↙
		moves[6].a = 0;
		moves[6].b = -1; // ←
		moves[7].a = -1;
		moves[7].b = -1; // ↖

//		[7][0][1] 이런 방을 만든거다. 여기에 생성자가 있네~
//		[6]   [2]
//		[5][4][3]

		// Directions d;
		// d = Directions.N;
		// d = d + 1;//java는 지원안됨

		for (int i = 0; i < 14; i++) {
			for (int j = 0; j < 17; j++) {
				if ((i == 0) || (j == 0) || (i == 13) || (j == 16))
					maze[i][j] = 1;
				else {
					maze[i][j] = input[i - 1][j - 1];
				}
				mark[i][j] = 0;

			}
		}
		System.out.println("maze[12,15]::");
		for (int i = 0; i <= 13; i++) {
			for (int j = 0; j <= 16; j++) {
				System.out.print(maze[i][j] + " ");

			}
			System.out.println();
		}
		System.out.println("mark::");
		for (int i = 0; i <= 13; i++) {
			for (int j = 0; j <= 16; j++) {
				System.out.print(mark[i][j] + " ");

			}
			System.out.println();
		}
		path(maze, mark, 12, 15); // 이게 답이네?
		System.out.println("mark::");
		for (int i = 1; i <= 12; i++) {
			for (int j = 1; j <= 15; j++) {
				System.out.print(mark[i][j] + " ");

			}
			System.out.println();
		}

	}
}
