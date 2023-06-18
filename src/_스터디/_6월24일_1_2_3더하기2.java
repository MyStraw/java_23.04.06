package _스터디;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _6월24일_1_2_3더하기2 {

	static int pluscase(int x, int y, int z) {
		return factorial(x + y + z) / (factorial(x) * factorial(y) * factorial(z));
	}

	static int factorial(int n) {
		if (n == 0)
			n = 1;
		if (n <= 1) {
			return n;
		} else
			return factorial(n - 1) * n;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		int sum = 0;
		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			sum = 0;
			for (int x = 0; x <= 3; x++) {
				for (int y = 0; y <= 5; y++) {
					for (int z = 0; z <= 10; z++) {
						if (3 * x + 2 * y + z == n) {
							sum = sum + pluscase(x, y, z);
						}
					}
				}
			}
			bw.write(String.valueOf(sum + "\n"));
		}
		bw.flush();
		bw.close();
	}
}