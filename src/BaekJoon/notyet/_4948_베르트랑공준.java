package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _4948_베르트랑공준 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while (!br.readLine().equals("0")) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(isSosu(n));
		}
	}

	public static int isSosu(int n) {
		int count = 0;
		for (int i = n; i <= 2 * n; i++) {
			if (i > 1 && n != i && n % i == 0) {
				count++;
			} else if (n == 2) {
				count++;
			}
		}
		return count;
	}
}
