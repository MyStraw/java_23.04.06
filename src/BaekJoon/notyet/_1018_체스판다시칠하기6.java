package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1018_체스판다시칠하기6 {

	public static void main(String[] args) throws Exception { //gpt 생각한 가장 효율적 코드
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] board = new char[N][M];

		for (int i = 0; i < N; i++) {
			board[i] = br.readLine().toCharArray();
		}

		int minChanges = Integer.MAX_VALUE;
		for (int startRow = 0; startRow <= N - 8; startRow++) {
			for (int startCol = 0; startCol <= M - 8; startCol++) {
				minChanges = Math.min(minChanges, calculateChanges(board, startRow, startCol));
			}
		}

		System.out.println(minChanges);
	}

	private static int calculateChanges(char[][] board, int startRow, int startCol) {
		int minChanges = Integer.MAX_VALUE;
		for (int pattern = 0; pattern < 2; pattern++) {
			int changes = 0;
			char expectedColor = (pattern == 0) ? 'W' : 'B';
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (board[startRow + i][startCol + j] != expectedColor)
						changes++;
					expectedColor = (expectedColor == 'W') ? 'B' : 'W';
				}
				expectedColor = (expectedColor == 'W') ? 'B' : 'W';
			}
			minChanges = Math.min(minChanges, changes);
		}
		return minChanges;
	}
}
