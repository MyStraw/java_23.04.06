
package _bitcoding;

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
		top++;
		return 1;

	}

	public Point pop() throws EmptyGenericStackException {//
		if (isEmpty())
			throw new EmptyGenericStackException();
		{
			// Point p = data.get(top - 1);
			Point p = data.remove(top - 1); // 팝은 끄집어 내는거. 그럼 겟이 아니라 리무브가 맞다.
			top--;
			return p;
		}

	}

	public Point peek() throws EmptyGenericStackException { // 꼭대기는 값을 줘야하니 int가 아니라 Point
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
	public int x;
	public int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "(" + x + "," + y + ")"; // x,y 컴마컴이니까~
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

public class Chap5_Test_QueenEight_revised {

	static final int numberQueens = 4;

//	public static void SolveQueen(int[][] d) {
//		int count = 0, mode = 0;
//		int ix = 0, iy = 0;
//		Stack3 st = new Stack3(10); // 객체스택. 파일에서 가져오셈. point 다 가져와. 포인트 객체를 스택에 넣는다. 맨 윗줄부터 하면서 넣고. pop 하면 이게 x,y
//									// 좌표 갖고 있으니.
//		Point p = new Point(ix, iy); // 포인트 객체 만들어서 push. 다 가져왔다.
//		d[ix][iy] = 1;
//		count++; // 여왕을 놨다. 1개.
//		st.push(p);
//		while (count < numberQueens) {
//			ix++;
//			int cy = 0;
//			while (ix < numberQueens) {// 한칸씩 내려가면서 먼저 행을 먼저 잡고.
//				cy = nextMove(d, ix, cy);
//				do {
//					if (cy == -1) {
//						p = st.pop();				
//						cy=mode+1;					
//					}					
//					Point px = new Point(ix, cy);
//					st.push(px);
//					st.dump();
//					count++;
//					d[ix][cy] = 1;
//					mode=cy;
//					
//					break;
//				}while (cy < numberQueens && cy>=0);				
//			}
//		}
//	}

//	public static void SolveQueen(int[][] d) {
//		int count = 0, mode = 0;
//		int ix = 0, iy = 0;
//		Stack3 st = new Stack3(10); // 객체스택. 파일에서 가져오셈. point 다 가져와. 포인트 객체를 스택에 넣는다. 맨 윗줄부터 하면서 넣고. pop 하면 이게 x,y
//									// 좌표 갖고 있으니.
//		Point p = new Point(ix, iy); // 포인트 객체 만들어서 push. 다 가져왔다.
//		Point px = (Point) p;
//		d[ix][iy] = 1;
//		count++; // 여왕을 놨다. 1개.
//		st.push(p);
//		while (count < numberQueens) {
//			ix++;
//			int cy = 0;
//			while (ix < numberQueens) {
//				cy = nextMove(d, ix, cy);
//				while (cy != -1 && cy < numberQueens) {
//					st.push(px);
//					count++;
//					break;
//				}
//				if (cy != numberQueens) {
//					break;
//				} else {
//					p = st.pop();
//					count--;
//				}
//
//			}
//		}
//	}

	public static void SolveQueen(int[][] d) {

		int count = 0;
		int ix = 0, iy = 0;
		Stack3 st = new Stack3(numberQueens);
		Point p = new Point(ix, iy);
		d[ix][iy] = 1;
		count++;
		st.push(p);

		while (count < numberQueens) {
			ix++;
			int cy = 0;
			while (ix < numberQueens) {
				cy = nextMove(d, ix, cy);
				System.out.println("ix = " + ix + " cy = " + cy);
				if (cy == -1) {
					System.out.println("pop");
					p = st.pop();
					ix = p.x;
					cy = p.y;
					d[ix][cy] = 0;				
					count--;
					cy++;
				} else {
					Point px = new Point(ix, cy);
					st.push(px);
					d[ix][cy] = 1;
					count++;
					break;
				}
			}
		}
	}

//		while (count < numberQueens) {
//			ix++;
//			int cy = 0;
//			while (ix < numberQueens) {
//				cy = nextMove(d, ix, cy);
//				System.out.println("ix = " + ix + "cy = " + cy);
//				if (cy == -1) {
//				
//						p = st.pop();
//						ix = p.x;
//						cy = p.y;
//						d[ix][cy] = 0;
//						count--;
//						cy++;
//				
//				} else {
//					Point px = new Point(ix, cy);
//					st.push(px);
//					d[ix][cy] = 1;
//					count++;
//					break;
//				}
//			}
//		}
//	}

	public static boolean checkRow(int[][] d, int crow) { // 가로 체크
		// 배열 d에서 crow에 Queen을 놓을수 있느냐?
		for (int j = 0; j < numberQueens; j++)
			if (d[crow][j] == 1)
				return false; // 1이 있으면 퀸이 있단거니까.
		return true;
	}

	public static boolean checkCol(int[][] d, int ccol) { // 세로 체크 (data, y=0)
		// 배열 d에 ccol 열에 배치할 수 있느냐? 있다면 true로 리턴
		for (int j = 0; j < numberQueens; j++)
			if (d[j][ccol] == 1)
				return false;
		return true;
	}

	public static boolean checkDiagSW(int[][] d, int x, int y) {
		int cx = x, cy = y;
		while ((cx >= 0 && cx < numberQueens) && (cy >= 0 && cy < numberQueens)) {

			if (d[cx][cy] == 1)
				return false;
			cx++;
			cy--;
		}
		cx = x;
		cy = y;
		while ((cx >= 0 && cx < numberQueens) && (cy >= 0 && cy < numberQueens)) {

			if (d[cx][cy] == 1)
				return false;
			cx--;
			cy++;
		}
		return true;
	}

	public static boolean checkDiagSE(int[][] d, int x, int y) {
		int cx = x, cy = y;
		while ((cx >= 0 && cx < numberQueens) && (cy >= 0 && cy < numberQueens)) {

			if (d[cx][cy] == 1)
				return false;
			cx++;
			cy++;
		}
		cx = x;
		cy = y;
		while ((cx >= 0 && cx < numberQueens) && (cy >= 0 && cy < numberQueens)) {

			if (d[cx][cy] == 1)
				return false;
			cx--;
			cy--;
		}
		return true;
	}

	public static boolean checkMove(int[][] d, int x, int y) {// (x,y)로 이동 가능한지를 check
		if (checkRow(d, x) && checkCol(d, y) && checkDiagSW(d, x, y) && checkDiagSE(d, x, y))
			return true;
		else
			return false;
	}

	public static int nextMove(int[][] d, int row, int newcol) {// 다음 row에 대하여 이동할 col을 조사 // ex) 4X4일때 (0,0)에 퀸이 있을경우,
		// 다음 넣을자리 // row 1일때 y를 한칸씩 열 이동시키면서 놔지는지 확인. y=2 자리에가능하네.
		for (int col = newcol; col < numberQueens; col++) {
			//System.out.println("row = " + row + "col = " + col);
			if (checkMove(d, row, col))
				return col;
		}
		return -1;
	}

//	public static boolean nextMove(int[][] d, int row, int newCol) {// 다음 row에 대하여 이동할 col을 조사 // ex) 4X4일때 (0,0)에 퀸이
//																	// 있을경우,
//		// 다음 넣을자리 // row 1일때 y를 한칸씩 열 이동시키면서 놔지는지 확인. y=2 자리에가능하네.
//		for (int col = 0; col < numberQueens; col++) {
//			if (checkMove(d, row, col)) {
//				newCol = col;
//				return true;
//			}
//			
//		}return false;
//	}

	public static void main(String[] args) {
		int row = numberQueens, col = numberQueens;
		int[][] data = new int[numberQueens][numberQueens];
		for (int i = 0; i < numberQueens; i++)
			for (int j = 0; j < numberQueens; j++)
				data[i][j] = 0; // 체스판 만들기

		SolveQueen(data);

		for (int i = 0; i < numberQueens; i++) {
			for (int j = 0; j < numberQueens; j++) {
				System.out.print(" " + data[i][j]);
			}
			System.out.println();
		}
	}
}
