package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _20551_sort마스터2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
		int[] B = A.clone();
		Arrays.sort(B);
		int[] D = new int[M];

		for (int i = 0; i < M; i++) {
			D[i] = Integer.parseInt(br.readLine());
			int result = Arrays.binarySearch(B, D[i]);

			if (result < 0) {
				System.out.println(-1);
			} else {
				while (result > 0 && B[result - 1] == D[i]) {
					result--;
				}
				System.out.println(result);
			}
		}
	}
}
