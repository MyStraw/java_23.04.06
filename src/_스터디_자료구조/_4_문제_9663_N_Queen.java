package _스터디_자료구조;

import java.util.Scanner;

public class _4_문제_9663_N_Queen {

	static int N; //체스판 가로세로 크기 NxN 
	static int[] x_chess; //퀸의 x좌표 y좌표. 즉 이미 놓인 애들의 위치
	static int[] y_chess;

	static int chess(int y, int x) {
		// 백트래킹
		for (int i = 0; i < y; i++) { // 현재 행 이전까지의 모든 행 체크하기
			if (y == y_chess[i] || x == x_chess[i])
				return 0; // 같은 행이나 열에 퀸이 있으면 false
			if (Math.abs(x - x_chess[i]) == Math.abs(y - y_chess[i])) // 현재 놓인 위치, 놓을 위치 거리가 같으면 대각선이지. -2건 2건 어쨌거나 그 거리만 같으면 되니 절대값.
				return 0; // 같은퀸 있으니까 이건 false
		}

		// y_chess[] 이건 이미 놓인 퀸의 위치고, y는 이제 놓을 위치
		// 종료 조건 - 재귀에선 이거 필수
		if (y == N - 1) // 맨 마지막 칸에 왔을때
			return 1; // 모든 행에 퀸이 배치되면 true

		// 현재좌표
		y_chess[y] = y; // 현재 행의 y 좌표 저장
		x_chess[y] = x; // x 좌표를 저장

		// 반복
		int count = 0; // 가능한 경우의수
		for (int i = 0; i < N; i++) { // 다음 행 모든 칸에 대해 퀸 배치해보기
			count += chess(y + 1, i); // 카운트 더하기
		}

		return count;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt(); // NxN 크기
		x_chess = new int[N]; // 행에 해당하는 배열도 당연히 N개 해야겠징
		y_chess = new int[N]; // 열도 당연히 N개

		int result = 0; // 최종 카운터수 결과
		for (int i = 0; i < N; i++) { // 첫 번째 행의 모든 열에 대해 퀸 넣어보기
			result += chess(0, i); // 첫 번째 행에 퀸 배치, 반복으로 호출해 다음 행도...
		}

		System.out.println(result);

	}

}
