package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1463_1로만들기2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int X = Integer.parseInt(br.readLine());
		int[] guess = new int[X + 1];

		for (int i = 2; i <= X; i++) {
			guess[i] = guess[i - 1] + 1;
			if (i % 2 == 0)
				guess[i] = Math.min(guess[i], guess[i / 2] + 1);
			if (i % 3 == 0)
				guess[i] = Math.min(guess[i], guess[i / 3] + 1);
		}

		bw.write(String.valueOf(guess[X]));
		bw.flush();
		bw.close();
	}
}
