package BaekJoon.notyet;

import java.util.Scanner;

public class _28426_더하기와나누기 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		scanner.close();

		StringBuilder result = new StringBuilder();
		int i = 2;
		
		result.append("3 ");
		
		for (int _n = N - 1; --_n > 0; i += 2) {
			result.append(i).append(" ");
		}
		if (N > 1) {
			result.append(i + (N % 3 == 2 ? 4 : 0));
		}
		
		System.out.println(result.toString().trim());
	}

}
