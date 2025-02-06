package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class _30046_HJS {
	static char[] chars = { 'H', 'J', 'S' };
	static int[] digits = new int[3];
	static boolean[] used = new boolean[10];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		String P = br.readLine();
		String Q = br.readLine();
		String R = br.readLine();

		if (dfs(P, Q, R, 0)) {
			bw.write("HJS! HJS! HJS!");
		} else {
			bw.write("Hmm...");
		}

		bw.flush();
		bw.close();
		br.close();
	}

	public static boolean dfs(String P, String Q, String R, int idx) {
		if (idx == 3) {
			long p = convert(P);
			long q = convert(Q);
			long r = convert(R);
			return p < q && q < r;
		}

		for (int i = 1; i <= 9; i++) {
			if (!used[i]) {
				used[i] = true;
				digits[idx] = i;
				if (dfs(P, Q, R, idx + 1)) {
					return true;
				}
				used[i] = false;
			}
		}

		return false;
	}

	public static long convert(String str) {
		long result = 0;
		for (char c : str.toCharArray()) {
			result = result * 10 + digits[Arrays.binarySearch(chars, c)];
		}
		return result;
	}

}
