package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1003_피보나치2 { // 이건 외워

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			int fibocount[] = new int[41];
			fibocount[0] = 0;
			fibocount[1] = 1;

			for (int j = 0; j < 39; j++) {
				fibocount[j + 2] = fibocount[j] + fibocount[j + 1];
			}

			if (N >= 1) {
				bw.write(String.valueOf(fibocount[N - 1]) + " ");
				bw.write(String.valueOf(fibocount[N]));
				bw.newLine();
			} else if (N == 0) {
				bw.write(String.valueOf("1 "));
				bw.write(String.valueOf("0"));
				bw.newLine();
			}

		}
		bw.flush();
		bw.close();
	}

}
