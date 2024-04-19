package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1018_체스판다시칠하기3 { //gpt가 내준 답.
	static char[][] white = { { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' }, { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
			{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' }, { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
			{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' }, { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
			{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' }, { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' } };

	static char[][] black = { { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' }, { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
			{ 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' }, { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
			{ 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' }, { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
			{ 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' }, { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] board = new char[N][M];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			board[i] = line.toCharArray();
		}

		int minChanges = Integer.MAX_VALUE;

		// 모든 가능한 8x8 부분 체스판에 대해 검사
		for (int startRow = 0; startRow <= N - 8; startRow++) {
			for (int startCol = 0; startCol <= M - 8; startCol++) {
				int changesWhite = calculateChanges(board, startRow, startCol, true);
				int changesBlack = calculateChanges(board, startRow, startCol, false);
				minChanges = Math.min(minChanges, Math.min(changesWhite, changesBlack));
			}
		}

		System.out.println(minChanges);
	}

	// 이 함수는 부분 체스판에 대해 필요한 변경 횟수를 계산합니다.
	// isWhiteStart는 부분 체스판이 white로 시작하는지 여부를 나타냅니다.
	// 실제 구현 필요 (예시 코드에는 포함되어 있지 않음)
	private static int calculateChanges(char[][] board, int startRow, int startCol, boolean isWhiteStart) {
		int changes = 0;
		char[][] referenceBoard = isWhiteStart ? white : black; // 비교할 기준 패턴 결정

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (board[startRow + i][startCol + j] != referenceBoard[i][j]) {
					changes++;
				}
			}
		}

		return changes;
	}
}
