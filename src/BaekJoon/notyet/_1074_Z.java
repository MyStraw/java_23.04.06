package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1074_Z {
	static int[][] Z;
	static int count = -1;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken()); // 입력
		int r = Integer.parseInt(st.nextToken()); // 행
		int c = Integer.parseInt(st.nextToken()); // 열

		System.out.println(Z재귀(n, r, c));
	}

	static int Z재귀(int n, int x, int y) {
		if (n == 0) {
			return 0;
		}

		int half = 1 << (n - 1);

		if (x < half && y < half) { // 1분면
			return Z재귀(n - 1, x, y);
		} else if (x < half && y >= half) { // 2분면
			return half * half + Z재귀(n - 1, x, y - half);
		} else if (x >= half && y < half) { // 3분면
			return 2 * half * half + Z재귀(n - 1, x - half, y);
		} else { // 4분면
			return 3 * half * half + Z재귀(n - 1, x - half, y - half);
		}
	}
}
