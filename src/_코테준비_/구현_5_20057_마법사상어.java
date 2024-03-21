package _코테준비_;

import java.util.Scanner;

public class 구현_5_20057_마법사상어 {

	static int N;
	static int[][] grid;
	static int[] dx = { 0, 1, 0, -1 }; // 서, 남, 동, 북
	static int[] dy = { -1, 0, 1, 0 };
	static int result = 0;

	public static void moveTornado() {
		int x = N / 2;
		int y = N / 2;
		int direction = 0; // 초기 방향: 서쪽
		int moveCount = 1;

		while (true) {
			if (x == 0 && y == 0)
				break; // 토네이도가 격자의 중앙에 도달하면 종료

			for (int i = 0; i < moveCount; i++) {
				x += dx[direction];
				y += dy[direction];

				// 모래 분배 로직 (구현 필요)

				if (x == 0 && y == 0)
					break;
			}
			direction = (direction + 1) % 4;
			if (direction == 0 || direction == 2)
				moveCount++; // 서쪽 또는 동쪽으로 이동 후 이동 거리 증가
		}
	}

	// 모래 분배 로직 구현
	public static void spreadSand(int x, int y, int direction) {
		// 여기에 모래를 분배하는 로직을 구현합니다.
		// 격자 밖으로 나간 모래의 양을 result에 더합니다.
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		grid = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				grid[i][j] = scanner.nextInt();
			}
		}

		moveTornado();

		System.out.println(result);
		scanner.close();
	}

}
