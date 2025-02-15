package _백준대회.KSA_2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _B_저녁태권도 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int A[] = new int[M];
		int B[] = new int[M];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			A[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
		}

		int L[] = new int[M];
		int totalMaxAbs = 0;
		for (int i = 0; i < M; i++) {
			L[i] = N - (A[i] + B[i]);
			totalMaxAbs += L[i];
		}

		if (totalMaxAbs < N) {
			System.out.println("NO");
			return;
		}

		// 카드 다 배정
		int absStu[] = new int[M];
		int remainCard = N;
		for (int i = 0; i < M; i++) {
			absStu[i] = Math.min(remainCard, L[i]);
			remainCard -= absStu[i];
		}
		// 애들 시간표
		char[][] timeTable = new char[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				timeTable[i][j] = '?';
			}
		}
		boolean alreadyAbs[] = new boolean[N];

		for (int i = 0; i < M; i++) {
			int count = absStu[i];
			for (int j = 0; j < N && count > 0; j++) {
				if (!alreadyAbs[j]) {
					timeTable[j][i] = 'X';
					alreadyAbs[j] = true;
					count--;
				}
			}
		}

		for (int i = 0; i < M; i++) {
			int morningCount = 0;
			int eveningCount = 0;
			for (int j = 0; j < N; j++) {
				if (timeTable[j][i] != 'X') {
					if (morningCount < A[i]) {
						timeTable[j][i] = '+';
						morningCount++;
					} else if (eveningCount < B[i]) {
						timeTable[j][i] = '-';
						eveningCount++;
					} else {
						timeTable[j][i] = '+';
					}
				}

			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append("YES\n");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(timeTable[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());

	}

}
