package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _2775_부녀회장이_될테야 {
	public static int apartment(int k, int n) {

		int[][] people = new int[k + 1][n + 1]; // 0층 포함

		for (int i = 1; i <= n; i++) {
			people[0][i] = i;
		}

		for (int floor = 1; floor <= k; floor++) {
			for (int ho = 1; ho <= n; ho++) {
				people[floor][ho] = people[floor][ho-1] + people[floor-1][ho];
			}
		}
		return people[k][n];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수 읽기

		for (int i = 0; i < T; i++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());

			int ho = apartment(k, n);
			bw.write(ho + "\n"); // 결과 쓰기
		}

		bw.flush(); // 버퍼에 남아있는 데이터 모두 출력
		bw.close(); // 버퍼 닫기
		br.close(); // 리더 닫기
	}
}
