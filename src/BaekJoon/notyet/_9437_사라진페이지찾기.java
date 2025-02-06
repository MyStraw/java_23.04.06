package BaekJoon.notyet;

import java.util.Scanner;

public class _9437_사라진페이지찾기 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			int N = scanner.nextInt();
			if (N == 0)
				break;
			int P = scanner.nextInt();

			int mid = N / 2;
			int idx = (P - 1) / 2;

			int page1 = 2 * idx + 1;
			int page2 = 2 * idx + 2;
			int page3 = N - 2 * idx;
			int page4 = N - 2 * idx - 1;

			if (P == page1) {
				hidePage(page2, page3, page4);
			} else if (P == page2) {
				hidePage(page1, page3, page4);
			} else if (P == page3) {
				hidePage(page1, page2, page4);
			} else if (P == page4) {
				hidePage(page1, page2, page3);
			}
		}
	}

	private static void hidePage(int p1, int p2, int p3) {
		int[] page = { p1, p2, p3 };
		java.util.Arrays.sort(page);
		System.out.println(page[0] + " " + page[1] + " " + page[2]);
	}

}
