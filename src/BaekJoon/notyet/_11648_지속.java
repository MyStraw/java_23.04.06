package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11648_지속 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num = br.readLine();

		int step = 0;

		while (num.length() > 1) {
			int product = 1;
			for (char c : num.toCharArray()) {
				product *= c - '0';
			}
			num = String.valueOf(product);
			step++;
		}

		System.out.println(step);
	}

}
