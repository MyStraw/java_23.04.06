package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1003_피보나치 {

	static int fibocount[] = new int[2];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			fibocount[0] = 0;
			fibocount[1] = 0;
			fibonacci(N);

			bw.write(String.valueOf(fibocount[0]) + " ");
			bw.write(String.valueOf(fibocount[1]));
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}

	public static int fibonacci(int n) {
		if (n == 0) {
			fibocount[0]++;
			return 0;
		} else if (n == 1) {
			fibocount[1]++;
			return 1;
		} else {
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}
}
