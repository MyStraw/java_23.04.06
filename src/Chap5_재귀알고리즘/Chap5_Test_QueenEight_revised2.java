
package Chap5_재귀알고리즘;

import java.util.ArrayList;
import java.util.List;

//https://www.geeksforgeeks.org/n-queen-problem-backtracking-3/?ref=lbp
//N Queen problem / backtracking

class EmptyGenericStackException extends RuntimeException { // 사용자정의 예외.
	public EmptyGenericStackException() { // 생성자
	}
}

// --- 실행시 예외: 스택이 가득 참 ---//
class OverflowGenericStackException extends RuntimeException {
	public OverflowGenericStackException() {
	}
}

class Stack3 {
	private List<Point> data; // 스택용 배열
	private int capacity; // 스택의 크기
	private int top; // 스택 포인터

	public Stack3(int maxlen) {
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

public class Chap5_Test_QueenEight_revised2 {
	public static void SolveQueen(int[][] d) {
		int count = 0, mode = 0;
		int ix = 0, iy = 0;
		Stack3 st = new Stack3(10); //객체스택. 파일에서 가져오셈. point 다 가져와. 포인트 객체를 스택에 넣는다. 맨 윗줄부터 하면서 넣고. pop 하면 이게 x,y 좌표 갖고 있으니. 
		Point p = new Point(ix, iy); //포인트 객체 만들어서 push. 다 가져왔다.
		Point px = (Point) p;
		d[ix][iy] = 1;
		count++; // 여왕을 놨다. 1개.
		st.push(p);
		while (count < 8) {
			ix++;
			int cy = 0;
			while (ix < d.length) {//한칸씩 내려가면서 먼저 행을 먼저 잡고.

				while (cy < d[0].length) {

					st.push(px);
					count++;
					break;

				}
				if (cy != d[0].length) {
					break;
				} else {
					p = st.pop();
					count--;

				}
			}
		}
	}

	public static boolean checkRow(int[][] d, int crow) { // 가로 체크
		for (int i = 0; i<d.length; i++)
			if (d[i][crow] ==1)
				return false;
		return true;
	}

	public static boolean checkCol(int[][] d, int ccol) { // 세로 체크 (data, y=0)
		for (int i = 0; i<d.length; i++)
			if (d[ccol][i] ==1)
				return false;
		return true;
	}

	public static boolean checkDiagSW(int[][] d, int cx, int cy) { // 대각선 왼쪽아래 체크 x++, y-- or x--, y++ where 0<= x,y <=
		while (cx < d.length && cy >= 0) {
			if (d[cx][cy] == 1)
				return false;
			cx++;
			cy--;
		}											

		return true;
	}

	public static boolean checkDiagSE(int[][] d, int cx, int cy) {// 대각선 오른족아래(south east) x++, y++ or x--, y--
		while (cx < d.length && cy < d.length) {
			if (d[cx][cy] == 1)
				return false;
			cx++;
			cy++;
		}
		return true;
	}

	public static boolean CheckMove(int[][] d, int x, int y) {// (x,y)로 이동 가능한지를 check
		return checkRow(d, x) && checkCol(d, y) && checkDiagSW(d, x, y) && checkDiagSE(d, x, y);
	}

	public static boolean NextMove(int[][] d, int row) {// 다음 row에 대하여 이동할 col을 조사 // ex) 4X4일때 (0,0)에 퀸이 있을경우, row 1일때 y를 한칸씩 열 이동시키면서 놔지는지 확인. y=2 자리에가능하네.
		for (int col = 0; col < d.length; col++) {
			if (CheckMove(d, row, col)) {
				d[row][col] = 1;
				if (row == d.length - 1 || NextMove(d, row + 1))
					return true;
				d[row][col] = 0;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int row = 8, col = 8;
		int[][] data = new int[8][8];
		for (int i = 0; i < data.length; i++)
			for (int j = 0; j < data[0].length; j++)
				data[i][j] = 0; // 체스판 만들기

		SolveQueen(data);

		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[0].length; j++) {
				System.out.print(" " + data[i][j]);
			}
			System.out.println();
		}
	}
}
