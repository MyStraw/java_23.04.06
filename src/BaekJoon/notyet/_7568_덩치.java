package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class _7568_덩치 {

	static class Body {
		private int x;
		private int y;

		public Body(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

		public String toString() {
			return x + " " + y;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		List<Body> body = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			body.add(i, new Body(x, y));
		}

		Collections.sort(body, new Comparator<Body>() {
			@Override
			public int compare(Body b1, Body b2) {
				int xyCompare = Integer.compare(b1.getX(), b2.getX());
				if (xyCompare == 0) {
					return Integer.compare(b1.getY(), b1.getY());
				}
				return xyCompare;
			}
		});

		for (Body xy : body) {
			bw.write(String.valueOf(xy + "\n"));
		}
		bw.flush();
		bw.close();

	}
}
