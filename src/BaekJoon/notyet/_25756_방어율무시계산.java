package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _25756_방어율무시계산 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		String[] str = br.readLine().split(" ");

		double[] bangmu = new double[N];

		for (int i = 0; i < N; i++) {
			bangmu[i] = Integer.parseInt(str[i]) / 100.0;
		}

		double nowBangMu = 0.0;

		for (int i = 0; i < N; i++) {
			nowBangMu = 1 - (1 - nowBangMu) * (1 - bangmu[i]);
			System.out.printf("%.6f\n", nowBangMu * 100);
		}

	}
}
