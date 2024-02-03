package BaekJoon.notyet;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class _1308_DDay {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int todayY = sc.nextInt();
		int todayM = sc.nextInt();
		int todayD = sc.nextInt();
		LocalDate today = LocalDate.of(todayY, todayM, todayD);

		int DDayY = sc.nextInt();
		int DDayM = sc.nextInt();
		int DDayD = sc.nextInt();
		LocalDate dDay = LocalDate.of(DDayY, DDayM, DDayD);

		LocalDate thousand = today.plusYears(1000);

		if (DDayY - todayY > 1000 || (DDayY - todayY == 1000
				&& (DDayM > todayM || (DDayM == todayM && DDayD >= todayD)))) {
			System.out.println("gg");
		} else {
			long dayGap = ChronoUnit.DAYS.between(today, dDay);
			System.out.println("D-" + dayGap);
		}
	}
}