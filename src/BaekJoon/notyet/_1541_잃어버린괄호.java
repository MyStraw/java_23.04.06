package BaekJoon.notyet;

import java.util.Scanner;

public class _1541_잃어버린괄호 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		String[] minus = str.split("-");

		int result = 0;

		for (int i = 0; i < minus.length; i++) {
			String part = minus[i];
			String[] plus = part.split("\\+");

			int sum = 0;
			for (String num : plus) {
				sum += Integer.parseInt(num);
			}

			if (i == 0) {
				result += sum;
			} else {
				result -= sum;
			}
		}

		System.out.println(result);

	}

}
