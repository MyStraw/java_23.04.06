package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _30971_육회비빔밥 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] A = new int[N];
		int[] B = new int[N];
		int[] C = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			C[i] = Integer.parseInt(st.nextToken());
		}

		int total = 0;
		boolean canEat = true;

		for (int i = 1; i < N; i++) {
			int eyeChi = C[i - 1] * C[i];
			if (eyeChi > K) {
				canEat = false;
				break;
			}
			total += A[i - 1] * B[i];
		}

		if (canEat) {
			System.out.println(total);
		} else {
			System.out.println(-1);
		}
	}

}
