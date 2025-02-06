package BaekJoon.notyet;

import java.util.Scanner;

public class _16199_나이계산하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int birthYear = sc.nextInt();
		int birthMonth = sc.nextInt();
		int birthDay = sc.nextInt();

		int currentYear = sc.nextInt();
		int currentMonth = sc.nextInt();
		int currentDay = sc.nextInt();

		int fullAge = currentYear - birthYear;
		if (currentMonth < birthMonth || (currentMonth == birthMonth && currentDay < birthDay)) {
			fullAge--;
		}

		int countingAge = currentYear - birthYear + 1;

		int yearAge = currentYear - birthYear;

		System.out.println(fullAge);
		System.out.println(countingAge);
		System.out.println(yearAge);

		sc.close();
	}

}
