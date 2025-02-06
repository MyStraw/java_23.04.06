package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1002_터렛 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());

			int dx = x2 - x1;
			int dy = y2 - y1;
			int distSq = dx * dx + dy * dy;

			int sumR = r1 + r2;
			int diffR = Math.abs(r1 - r2);
			int sumRSq = sumR * sumR;
			int diffRSq = diffR * diffR;

			if (distSq == 0) {
				if (r1 == r2) {
					sb.append("-1\n");
				} else {
					sb.append("0\n");
				}
			} else if (distSq > sumRSq) {
				sb.append("0\n");
			} else if (distSq < diffRSq) {
				sb.append("0\n");
			} else if (distSq == sumRSq || distSq == diffRSq) {
				sb.append("1\n");
			} else {
				sb.append("2\n");
			}
		}

		System.out.print(sb.toString());
	}

}
