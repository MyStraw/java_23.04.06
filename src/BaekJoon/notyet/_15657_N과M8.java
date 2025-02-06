package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _15657_N과M8 {
	static int N, M;
	static int[] numbers;
	static int[] sequence;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		numbers = new int[N];
		sequence = new int[M];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(numbers);

		backtrack(0, 0);
	}

	static void backtrack(int count, int start) {
		if (count == M) {
			for (int num : sequence) {
				System.out.print(num + " ");
			}
			System.out.println();
			return;
		}

		for (int i = start; i < N; i++) { 
			sequence[count] = numbers[i]; 
			backtrack(count + 1, i); 
		}
	}

}
