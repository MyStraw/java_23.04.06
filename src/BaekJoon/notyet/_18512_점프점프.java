package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _18512_점프점프 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int P1 = Integer.parseInt(st.nextToken());
		int P2 = Integer.parseInt(st.nextToken());

		boolean jump = false;

		for (int i = 0; i <= 100; i++) {
			if (jump) {
				break;
			}
			for (int j = 0; j <= 100; j++) {
				if (P1 + (X * i) == P2 + (Y * j)) {
					System.out.println(P1 + (X * i));
					jump = true;
				}
			}
		}
		if(!jump) {
			System.out.println(-1);
		}
	}

}
