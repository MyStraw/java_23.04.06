package _백준대회.나는코더다_2024_송년대회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class I번_수열과수열 {
	static int N;
	static int[] A, B;
	static List<int[]> operations = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력 처리
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		B = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}

		// 배열이 이미 같은지 확인
		if (Arrays.equals(A, B)) {
			System.out.println(0);
			return;
		}

		// 정렬 가능성 확인
		int[] sortedA = A.clone();
		int[] sortedB = B.clone();
		Arrays.sort(sortedA);
		Arrays.sort(sortedB);

		// 두 배열의 원소가 다르다면 변환 불가능
		if (!Arrays.equals(sortedA, sortedB)) {
			System.out.println(-1);
			return;
		}

		// 변환 수행
		transform();

		// 결과 출력
		System.out.println(operations.size());
		for (int[] op : operations) {
			System.out.println((op[0] + 1) + " " + (op[1] + 1));
		}
	}

	static void transform() {
		// 각 위치에 대해 올바른 값을 찾아 정렬
		for (int i = 0; i < N; i++) {
			if (A[i] == B[i])
				continue;

			// B[i]와 같은 값을 A배열에서 찾기
			int targetIdx = -1;
			for (int j = i + 1; j < N; j++) {
				if (A[j] == B[i]) {
					targetIdx = j;
					break;
				}
			}

			// targetIdx까지의 거리가 짝수라면 한 칸 더 뒤로 이동
			if ((targetIdx - i) % 2 == 0 && targetIdx < N - 1) {
				swap(targetIdx, targetIdx + 1);
				targetIdx++;
			}

			// 값을 올바른 위치로 이동
			while (targetIdx > i) {
				swap(targetIdx - 1, targetIdx);
				targetIdx--;
			}
		}
	}

	static void swap(int i, int j) {
		// i부터 j까지의 구간에 대해 연산 수행
		operations.add(new int[] { i, j });
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

}
