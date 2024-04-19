package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1018_체스판다시칠하기4 { //내가 생각한, 큰 틀은 입력으로 [][] 로 받고, white, black를 queue 배열에 넣어서 쏴주면서 확인
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
			board[i] = br.readLine().toCharArray();
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

	// 변경된 calculateChanges 함수
	private static int calculateChanges(char[][] board, int startRow, int startCol, boolean isWhiteStart) {
		Queue<Character> patternQueue = new LinkedList<>();
		// 선택된 패턴의 초기화
		char[][] pattern = isWhiteStart ? white : black;
		for (int i = 0; i < 8; i++) {
			for (char c : pattern[i]) {
				patternQueue.add(c);
			}
		}

		int changes = 0;
		for (int row = startRow; row < startRow + 8; row++) {
			for (int col = startCol; col < startCol + 8; col++) {
				char current = board[row][col];
				char expected = patternQueue.poll();
				if (current != expected)
					changes++;
				patternQueue.add(expected); // 순환 구조 유지
			}
		}
		return changes;
	}
}
