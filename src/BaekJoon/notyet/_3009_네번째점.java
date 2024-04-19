package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _3009_네번째점 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int x1 = 0;
		int x2 = 0;
		int y1 = 0;
		int y2 = 0;
		int x1Count = 0;
		int x2Count = 0;
		int y1Count = 0;
		int y2Count = 0;

		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			if (x1 == 0) {
				x1 = x;
				x1Count++;
			} else if (x != x1) {
				x2 = x;
				x2Count++;
			} else if (x != 0 && x == x1) {
				x1Count++;
			} else if (x != 0 && x == x2) {
				x2Count++;
			}

			if (y1 == 0) {
				y1 = y;
				y1Count++;
			} else if (y != y1) {
				y2 = y;
				y2Count++;
			} else if (y != 0 && y == y1) {
				y1Count++;
			} else if (y != 0 && y == y2) {
				y2Count++;
			}

		}

		if (x1Count == 1) {
			bw.write(x1 + " ");

		} else if (x2Count == 1)
			bw.write(x2 + " ");

		if (y1Count == 1) {
			bw.write(y1 + " ");

		} else if (y2Count == 1) {
			bw.write(y2 + " ");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
