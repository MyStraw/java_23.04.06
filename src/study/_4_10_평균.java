package study;

import java.util.Scanner;

public class _4_10_평균 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		double Subject[] = new double[N];
		double max = 0;
		double sum = 0;
		double avg = 0;

		for (int i = 0; i < N; i++) {
			int sub = sc.nextInt();
			Subject[i] = sub;
		}

		for (int i = 0; i < N; i++) {
			if (Subject[i] > max) {
				max = Subject[i];
			}
		}

		for (int i = 0; i < N; i++) {
			Subject[i] = (Subject[i] / max) * 100;
			sum += Subject[i];
		}

		avg = sum / N;

		System.out.println(avg);

	}

}
