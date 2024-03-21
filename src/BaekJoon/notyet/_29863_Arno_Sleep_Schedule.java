package BaekJoon.notyet;

import java.util.Scanner;

public class _29863_Arno_Sleep_Schedule {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int sleep = sc.nextInt();
		int wake = sc.nextInt();

		int total = 0;

		if (sleep >= 20 && sleep <= 23) {
			total = (24 - sleep) + wake;
		}

		else {
			total = wake - sleep;
			if (total < 0) {
				total += 24;
			}

		}
		
		System.out.println(total);

	}

}
