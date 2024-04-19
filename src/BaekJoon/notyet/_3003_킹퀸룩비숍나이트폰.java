package BaekJoon.notyet;

import java.io.IOException;
import java.util.Scanner;

public class _3003_킹퀸룩비숍나이트폰 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int[] a = new int[6];
		int b = 0;

		a[0] = 1;
		a[1] = 1;
		a[2] = 2;
		a[3] = 2;
		a[4] = 2;
		a[5] = 8;

		int chess = 0;
		for (int i = 0; i < 6; i++) {
			b = sc.nextInt();
			System.out.print((chess = a[i] - b) + " ");

		}

	}

}
