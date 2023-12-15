package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class _11651_좌표정렬하기2 {
	static class XandY {
		private int X;
		private int Y;

		public XandY() {
		}

		public XandY(int X, int Y) {
			this.X = X;
			this.Y = Y;
		}

		public int getX() {
			return X;
		}

		public int getY() {
			return Y;
		}
		
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
			XY[i] = new XandY(x, y);
		}

		Arrays.sort(XY, new Comparator<XandY>() {
			@Override
			public int compare(XandY o1, XandY o2) {
				int xyCompare = Integer.compare(o1.getY(), o2.getY());
				if (xyCompare == 0) {
					return Integer.compare(o1.getX(), o2.getX());
				}
				return xyCompare;
			}
		});
		
		for (XandY xy : XY) {
			bw.write(String.valueOf(xy+"\n"));
		}
		bw.flush();
		bw.close();

	}

}
