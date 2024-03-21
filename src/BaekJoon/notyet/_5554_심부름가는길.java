package BaekJoon.notyet;

import java.util.Scanner;

public class _5554_심부름가는길 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int HomeToSchool = sc.nextInt();
		int SchoolToPC = sc.nextInt();
		int PCToAca = sc.nextInt();
		int AcaToHome = sc.nextInt();

		int total = HomeToSchool + SchoolToPC + PCToAca + AcaToHome;

		int min = total / 60;
		int sec = total % 60;

		System.out.println(min);
		System.out.println(sec);
	}

}
