package BaekJoon.notyet;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class __31475_양갈래배열출력하기 {
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = 3;
		int M = 3;
		int[][] array = new int[N][M];

		fillArraySnail(array, N, M);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				bw.write(array[i][j] + " ");
			}
			bw.newLine();
		}

		bw.flush();
		bw.close();
	}

	private static void fillArraySnail(int[][] array, int N, int M) {
		int num = 1;
		int x = 0, y = M - 1; // 시작점: 첫 번째 행, 마지막 열
		int[][] directions = { { 1, 0 }, { 0, -1 }, { -1, 0 }, { 0, 1 } }; // 아래, 왼쪽, 위, 오른쪽
		int directionIndex = 0;
		int steps = 1;

		array[x][y] = num++;

		while (num <= N * M) {
			int dx = directions[directionIndex][0];
			int dy = directions[directionIndex][1];
			int nextX = x + dx;
			int nextY = y + dy;

			if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && array[nextX][nextY] == 0) {
				x = nextX;
				y = nextY;
				array[x][y] = num++;
			} else {
				directionIndex = (directionIndex + 1) % 4;
			}
		}
	}
}
