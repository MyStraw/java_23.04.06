package _백준대회.SciOI_2024;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class D번_격자와쿼리 {
	public static void main(String[] args) throws IOException {
		// 입력을 위한 BufferedReader와 출력 최적화를 위한 BufferedWriter 설정
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 첫 번째 줄에서 N(격자 크기)과 Q(쿼리 수) 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		// 행과 열의 합을 저장할 배열 초기화
		long[] rowSum = new long[N + 1];
		long[] colSum = new long[N + 1];

		// 각 행과 열의 상태 저장 변수
		int[] rowValue = new int[N + 1];
		int[] colValue = new int[N + 1];
		boolean[] isRowSet = new boolean[N + 1];
		boolean[] isColSet = new boolean[N + 1];

		// 쿼리 처리
		while (Q-- > 0) {
			st = new StringTokenizer(br.readLine());
			int type = Integer.parseInt(st.nextToken());
			int i = Integer.parseInt(st.nextToken());

			if (type == 1) { // 행 변경 쿼리
				int v = Integer.parseInt(st.nextToken());
				// 기존 행 값 업데이트
				if (isRowSet[i]) {
					rowSum[i] = (long) v * N;
				} else {
					rowSum[i] = (long) v * N - colSum[i];
				}
				rowValue[i] = v;
				isRowSet[i] = true;
			} else if (type == 2) { // 열 변경 쿼리
				int v = Integer.parseInt(st.nextToken());
				// 기존 열 값 업데이트
				if (isColSet[i]) {
					colSum[i] = (long) v * N;
				} else {
					colSum[i] = (long) v * N - rowSum[i];
				}
				colValue[i] = v;
				isColSet[i] = true;
			} else if (type == 3) { // 행의 합 출력 쿼리
				long sum = 0;
				if (isRowSet[i]) {
					sum = (long) rowValue[i] * N; // 행 전체가 동일한 값으로 설정된 경우
				} else {
					for (int j = 1; j <= N; j++) { // 행에서 개별 열 값 추가
						sum += isColSet[j] ? colValue[j] : 0;
					}
				}
				bw.write(sum + "\n");
			} else if (type == 4) { // 열의 합 출력 쿼리
				long sum = 0;
				if (isColSet[i]) {
					sum = (long) colValue[i] * N; // 열 전체가 동일한 값으로 설정된 경우
				} else {
					for (int j = 1; j <= N; j++) { // 열에서 개별 행 값 추가
						sum += isRowSet[j] ? rowValue[j] : 0;
					}
				}
				bw.write(sum + "\n");
			}
		}

		// 출력 버퍼를 비우고 마무리
		bw.flush();
		br.close();
		bw.close();
	}

}
