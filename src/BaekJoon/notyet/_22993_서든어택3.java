package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _22993_서든어택3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A[] = new int[N - 1];

		long junwoon = Long.parseLong(st.nextToken());
		for (int i = 0; i < N - 1; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(A);
		boolean allKill = true;
		for (int i = 0; i < N - 1; i++) {
			if (A[i] >= junwoon) {
				System.out.println("No");
				allKill = false;
				break;
			} else {
				junwoon += A[i];
			}
		}
		if (allKill) {
			System.out.println("Yes");
		}

	}

}
