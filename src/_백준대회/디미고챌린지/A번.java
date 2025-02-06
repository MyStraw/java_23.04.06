package _백준대회.디미고챌린지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A번 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] photo = br.readLine().split(" ");
		int A = Integer.parseInt(photo[0]);
		int B = Integer.parseInt(photo[1]);

		int result = 0;

		if (A % 2 == 1) {
			if (B % 2 == 1) {
				result = (B - A) / 2 + 1;
			} else {
				result = (B - A + 1) / 2;
			}
		} else {
			if (B % 2 == 1) {
				result = (B - A + 1) / 2 + 1;
			} else {
				result = (B - A) / 2 + 1;
			}
		}

		System.out.println(result);

	}

}
