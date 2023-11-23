package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2166_다각형의면적 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		double X[] = new double[N + 1];
		double Y[] = new double[N + 1];

		double total = 0;
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			X[i] = Integer.parseInt(st.nextToken());
			Y[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i < N; i++) {
			total += X[i] * Y[i + 1] - X[i + 1] * Y[i];
			if (i == N-1) {
				total += X[N] * Y[1] - X[1] * Y[N];
			}
		}

		System.out.printf("%.1f", Math.abs(total * 0.5));
	}

}
