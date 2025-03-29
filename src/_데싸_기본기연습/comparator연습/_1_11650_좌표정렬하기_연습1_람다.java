package _데싸_기본기연습.comparator연습;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class _1_11650_좌표정렬하기_연습1_람다 {

	static class XandY {
		private int X;
		private int Y;

		public XandY() {

		}

		public XandY(int x, int y) { // 이땐 매개변수라 부른다. 메서드나 생성자 정의할때. 파라메터
			X = x;
			Y = y;
		}

		public int getX() {
			return X;
		}

		public int getY() {
			return Y;
		}

		@Override
		public String toString() {
			return X + " " + Y;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		XandY[] XY = new XandY[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			XY[i] = new XandY(x, y); // 인스턴스 생성하는데 인자(아규먼트)로 x랑 y를 줄거야
		}

		Arrays.sort(XY, (o1, o2) -> {
			int xyCompare = Integer.compare(o1.getX(), o2.getX());
			return (xyCompare == 0) ? Integer.compare(o1.getY(), o2.getY()) : xyCompare;
		}); // XY가 XandY 클래스 타입으로 만들어졌으므로, o1, o2도 XandY로 인식한다.

		//Arrays.sort(XY, Comparator.comparingInt(XandY::getX).thenComparingInt(XandY::getY));
		// 위에거를 이거 한줄로 정리

		for (XandY xy : XY) {
			bw.write(xy.toString());
			bw.append("\n");
		}
		bw.flush();
		bw.close();

	}

}
