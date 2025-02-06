package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class _2210_숫자판점프 {

	static String[][] board = new String[5][5];
	static Set<String> numbers = new HashSet<>();
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				board[i][j] = st.nextToken();
			}
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				dfs(i, j, board[i][j]);
			}
		}

		bw.write(String.valueOf(numbers.size()));
		bw.flush();
		bw.close();
		br.close();
	}

	static void dfs(int x, int y, String number) {
		if (number.length() == 6) {
			numbers.add(number);
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5) {
				dfs(nx, ny, number + board[nx][ny]);
			}
		}
	}

}
