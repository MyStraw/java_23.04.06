package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class _2115_갤러리 {
	static int N, M;
	static char[][] field;
	static boolean[][] picked;
	static List<char[][]> patterns = Arrays.asList(new char[][] { { '.', '.' }, { 'X', 'X' } },
			new char[][] { { 'X', '.' }, { 'X', '.' } }, new char[][] { { 'X', 'X' }, { '.', '.' } },
			new char[][] { { '.', 'X' }, { '.', 'X' } });

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		field = new char[N][M];

		for (int i = 0; i < N; i++) {
			field[i] = br.readLine().toCharArray();
		}

		int result = solve();
		System.out.println(result);
	}

	static int solve() {
		int ret = 0;
		for (char[][] pattern : patterns) {
			ret += scan(pattern);
		}
		return ret;
	}

	static int scan(char[][] pattern) {
		picked = new boolean[N][M];
		int ret = 0;

		for (int i = 0; i < N - 1; i++) {
			for (int j = 0; j < M - 1; j++) {
				if (!picked[i][j] && match(i, j, pattern)) {
					pick(i, j);
					ret++;
				}
			}
		}

		return ret;
	}

	static boolean match(int y, int x, char[][] pattern) {
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				if (field[y + i][x + j] != pattern[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	static void pick(int y, int x) {
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				picked[y + i][x + j] = true;
			}
		}
	}

}
