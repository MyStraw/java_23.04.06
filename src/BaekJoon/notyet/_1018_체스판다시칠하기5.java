package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1018_체스판다시칠하기5 {

	public static void main(String[] args) throws Exception { //white, black 없이 하기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] board = new char[N][M];

		for (int i = 0; i < N; i++) {
			board[i] = br.readLine().toCharArray();
		}

		int minChanges = Integer.MAX_VALUE;

		// 모든 가능한 8x8 부분 체스판에 대해 검사
		for (int startRow = 0; startRow <= N - 8; startRow++) {
			for (int startCol = 0; startCol <= M - 8; startCol++) {
				int changesWhite = calculateChanges(board, startRow, startCol);
				int changesBlack = calculateChanges(board, startRow, startCol);
				minChanges = Math.min(minChanges, Math.min(changesWhite, changesBlack));
			}
		}

		System.out.println(minChanges);
	}

	// 변경된 calculateChanges 함수
	private static int calculateChanges(char[][] board, int startRow, int startCol) {
		int minChanges = Integer.MAX_VALUE; // 최소 변경 횟수를 저장할 변수

		// 두 가지 시작 패턴 (W 시작, B 시작)에 대해 검사
		for (int pattern = 0; pattern < 2; pattern++) {
			int changes = 0; // 이번 패턴에 대한 변경 횟수
			char expectedColor = (pattern == 0) ? 'W' : 'B'; // 시작 칸의 예상 색상

			// 부분 체스판의 각 칸을 검사
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					// 현재 칸의 실제 색상
					char actualColor = board[startRow + i][startCol + j];
					// 현재 칸에서 예상되는 색상이 실제 색상과 다른 경우
					if (actualColor != expectedColor) {
						changes++;
					}
					// 다음 칸으로 이동할 때 색상 변경 (W -> B, B -> W)
					expectedColor = (expectedColor == 'W') ? 'B' : 'W';
				}
				// 다음 행으로 이동할 때 시작 칸의 색상 변경
				expectedColor = (expectedColor == 'W') ? 'B' : 'W';
			}

			// 최소 변경 횟수 업데이트
			minChanges = Math.min(minChanges, changes);
		}

		return minChanges;
	}
}
