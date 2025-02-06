package BaekJoon.notyet;

import java.util.Scanner;

public class _9693_시파르 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int caseN = 1;

		while (true) {
			int N = sc.nextInt();
			if (N == 0)
				break;

			int result = zeroPPaegi(N);
			System.out.println("Case #" + caseN + ": " + result);
			caseN++;
		}

	}

	public static int zeroPPaegi(int N) {
		int count = 0;
		for (int i = 5; N / i >= 1; i *= 5) {
			count += N / i;
		}
		return count;
	}

}
