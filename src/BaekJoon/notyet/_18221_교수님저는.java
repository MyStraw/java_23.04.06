package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _18221_교수님저는 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] grid = new int[N][N];

		int sungkyuRow = -1, sungkyuCol = -1;
		int profRow = -1, profCol = -1;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
				if (grid[i][j] == 2) {
					sungkyuRow = i;
					sungkyuCol = j;
				} else if (grid[i][j] == 5) {
					profRow = i;
					profCol = j;
				}
			}
		}

		double distance = Math.sqrt(Math.pow(sungkyuRow - profRow, 2) + Math.pow(sungkyuCol - profCol, 2));
		if (distance < 5) {
			System.out.println(0);
			return;
		}

		if (sungkyuRow == profRow) {
			int count = 0;
			for (int j = Math.min(sungkyuCol, profCol) + 1; j < Math.max(sungkyuCol, profCol); j++) {
				if (grid[sungkyuRow][j] == 1) {
					count++;
				}
			}
			System.out.println(count >= 3 ? 1 : 0);
		} else if (sungkyuCol == profCol) {
			int count = 0;
			for (int i = Math.min(sungkyuRow, profRow) + 1; i < Math.max(sungkyuRow, profRow); i++) {
				if (grid[i][sungkyuCol] == 1) {
					count++;
				}
			}
			System.out.println(count >= 3 ? 1 : 0);
		} else {
			int topRow = Math.min(sungkyuRow, profRow);
			int bottomRow = Math.max(sungkyuRow, profRow);
			int leftCol = Math.min(sungkyuCol, profCol);
			int rightCol = Math.max(sungkyuCol, profCol);

			int count = 0;
			for (int i = topRow; i <= bottomRow; i++) {
				for (int j = leftCol; j <= rightCol; j++) {
					if (grid[i][j] == 1) {
						count++;
					}
				}
			}
			System.out.println(count >= 3 ? 1 : 0);
		}
	}

}
