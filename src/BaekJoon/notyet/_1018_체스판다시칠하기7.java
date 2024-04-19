package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1018_체스판다시칠하기7 {

	public static void main(String[] args) throws Exception { //미리 계산된 결과 적용. 6이랑 거의 같다 개념적으로. 메소드만 좀 달라짐.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] board = new char[N][M]; //입력받은 틀.

		for (int i = 0; i < N; i++) {
			board[i] = br.readLine().toCharArray(); //오잉? 이렇게 한방에 2차를 넣는다고?
		}

		int minChanges = Integer.MAX_VALUE;
		for (int startRow = 0; startRow <= N - 8; startRow++) { //2차배열의 시작점. 거기서부터 8x8을 잰다. 시작점만 알려주면 된다. 최대 크기를 넘어가면 안되니 -8까지만.
			for (int startCol = 0; startCol <= M - 8; startCol++) {
				minChanges = Math.min(minChanges, calculateChanges(board, startRow, startCol));
			}
		}

		System.out.println(minChanges);
	}

	private static int calculateChanges(char[][] board, int startRow, int startCol) {
	    int changesWhiteStart = 0;
	    int changesBlackStart = 0;

	    for (int i = 0; i < 8; i++) {
	        for (int j = 0; j < 8; j++) {
	            // 현재 위치에 따른 예상 색상 계산
	            char expectedColorWhiteStart = ((i + j) % 2 == 0) ? 'W' : 'B'; //w부터 시작하면 좌표의 합이 짝수다.
	            char expectedColorBlackStart = ((i + j) % 2 == 0) ? 'B' : 'W'; //b부터 시작하면 좌표의 합이 짝수다.

	            // 실제 색상
	            char actualColor = board[startRow + i][startCol + j];

	            // 변경 횟수 업데이트
	            if (actualColor != expectedColorWhiteStart) changesWhiteStart++;
	            if (actualColor != expectedColorBlackStart) changesBlackStart++;
	        }
	    }

	    // 두 시작 색상 중 최소 변경 횟수 반환
	    return Math.min(changesWhiteStart, changesBlackStart);
	}
}
