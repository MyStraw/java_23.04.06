package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _2212_센서 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		int[] sensor = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		if (K >= N) {
			System.out.println(0);
			return;
		}

		Arrays.sort(sensor);

		int[] distance = new int[N - 1];
		for (int i = 0; i < N - 1; i++) {
			distance[i] = sensor[i + 1] - sensor[i];
		}

		Arrays.sort(distance);

		int sum = 0;
		for (int i = 0; i < N - K; i++) {
			sum += distance[i];
		}

		System.out.println(sum);
	}

}
