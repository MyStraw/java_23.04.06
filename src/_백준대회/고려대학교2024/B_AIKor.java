package _백준대회.고려대학교2024;

import java.util.Scanner;

public class B_AIKor {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		scanner.close();

		long[] sequence = generateSequence(N);

		for (long num : sequence) {
			System.out.print(num + " ");
		}
	}

	public static long[] generateSequence(int N) {
		long[] sequence = new long[N + 1];
		long sum = 0;

		// Generate first N numbers
		for (int i = 0; i < N; i++) {
			sequence[i] = i + 1;
			sum += sequence[i];
		}

		// Calculate the average
		long average = sum / N;

		// Check if the average is already in the sequence
		boolean averageExists = false;
		for (int i = 0; i < N; i++) {
			if (sequence[i] == average) {
				averageExists = true;
				break;
			}
		}

		// If average exists, shift all numbers
		if (averageExists) {
			long shift = N + 1;
			for (int i = 0; i < N; i++) {
				sequence[i] += shift;
			}
			average += shift;
		}

		// Set the last number as the average
		sequence[N] = average;

		return sequence;
	}

}
