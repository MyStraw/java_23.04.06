package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _12102_종이접기2 {
	static int n, m;
	static int[][] p = new int[6][6];
	static int ans = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().split(" ");
		n = Integer.parseInt(nm[0]);
		m = Integer.parseInt(nm[1]);

		for (int i = 0; i < n; i++) {
			String[] line = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				p[i][j] = Integer.parseInt(line[j]);
			}
		}

		if (n == 1 && m == 1) {
			System.out.println(p[0][0]);
		} else {
			dfs(n, m, p);
			System.out.println(ans);
		}
	}

	static void dfs(int rlen, int clen, int[][] t) {
		ans = Math.max(ans, chk(rlen, clen, t));

		int[][] temp = new int[6][6];
		for (int i = 0; i < rlen; i++) {
			for (int j = 0; j < clen; j++) {
				temp[i][j] = t[i][j];
			}
		}

		if (rlen > 1) {
			for (int i = 1; i <= rlen / 2; i++) {
				if (rlen - i >= 1) {
					convert(rlen, clen, 0, i, t);
					dfs(Length(rlen, i), clen, t);
					for (int a = 0; a < rlen; a++) {
						for (int b = 0; b < clen; b++) {
							t[a][b] = temp[a][b];
						}
					}
				}
			}

			for (int i = 1; i <= rlen / 2; i++) {
				if (rlen - i >= 1) {
					convert(rlen, clen, 1, i, t);
					dfs(Length(rlen, i), clen, t);
					for (int a = 0; a < rlen; a++) {
						for (int b = 0; b < clen; b++) {
							t[a][b] = temp[a][b];
						}
					}
				}
			}
		}

		if (clen > 1) {
			for (int i = 1; i <= clen / 2; i++) {
				if (clen - i >= 1) {
					convert(rlen, clen, 2, i, t);
					dfs(rlen, Length(clen, i), t);
					for (int a = 0; a < rlen; a++) {
						for (int b = 0; b < clen; b++) {
							t[a][b] = temp[a][b];
						}
					}
				}
			}

			for (int i = 1; i <= clen / 2; i++) {
				if (clen - i >= 1) {
					convert(rlen, clen, 3, i, t);
					dfs(rlen, Length(clen, i), t);
					for (int a = 0; a < rlen; a++) {
						for (int b = 0; b < clen; b++) {
							t[a][b] = temp[a][b];
						}
					}
				}
			}
		}
	}

	static int Length(int total, int len) {
		if (len >= (total + 1) / 2) {
			return len;
		} else {
			return total - len;
		}
	}

	static int chk(int R, int C, int[][] t) {
		int ret = Integer.MIN_VALUE;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				ret = Math.max(ret, t[i][j]);
			}
		}
		return ret;
	}

	static void convert(int R, int C, int pos, int len, int[][] t) {
		int[][] temp = new int[6][6];

		if (pos == 0) {
			for (int i = 2 * len; i < R; i++) {
				for (int j = 0; j < C; j++) {
					temp[i - len][j] = t[i][j];
				}
			}
		} else if (pos == 2) {
			for (int i = 0; i < R; i++) {
				for (int j = 2 * len; j < C; j++) {
					temp[i][j - len] = t[i][j];
				}
			}
		}

		if (pos == 0) {
			int idx = len - 1;
			for (int u = 0, d = 2 * len - 1; u < d; u++, d--) {
				for (int j = 0; j < C; j++) {
					temp[idx][j] = t[u][j] + t[d][j];
				}
				--idx;
			}
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					t[i][j] = temp[i][j];
				}
			}
		} else if (pos == 1) {
			if (R - 2 * len >= 0) {
				for (int j = 0; j < C; j++) {
					for (int u = R - 2 * len, d = R - 1; u < d; u++, d--) {
						t[u][j] = t[u][j] + t[d][j];
						t[d][j] = 0;
					}
				}
			}
		} else if (pos == 2) {
			int idx = len - 1;
			for (int l = 0, r = 2 * len - 1; l < r; l++, r--) {
				for (int i = 0; i < R; i++) {
					temp[i][idx] = t[i][l] + t[i][r];
				}
				--idx;
			}
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					t[i][j] = temp[i][j];
				}
			}
		} else if (pos == 3) {
			if (C - 2 * len >= 0) {
				for (int l = C - 2 * len, r = C - 1; l < r; l++, r--) {
					for (int i = 0; i < R; i++) {
						t[i][l] = t[i][l] + t[i][r];
						t[i][r] = 0;
					}
				}
			}
		}
	}

}
