package BaekJoon;

import java.util.Scanner;

public class _2754_학점계산 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String score = sc.next();
		
		if (score.equals("A+")) {
			System.out.println("4.3");
		}
		if (score.equals("A0")) {
			System.out.println("4.0");
		}
		if (score.equals("A-")) {
			System.out.println("3.7");
		}
		if (score.equals("B+")) {
			System.out.println("3.3");
		}
		if (score.equals("B0")) {
			System.out.println("3.0");
		}
		if (score.equals("B-")) {
			System.out.println("2.7");
		}
		if (score.equals("C+")) {
			System.out.println("2.3");
		}
		if (score.equals("C0")) {
			System.out.println("2.0");
		}
		if (score.equals("C-")) {
			System.out.println("1.7");
		}
		if (score.equals("D+")) {
			System.out.println("1.3");
		}
		if (score.equals("D0")) {
			System.out.println("1.0");
		}
		if (score.equals("D-")) {
			System.out.println("0.7");
		}
		if (score.equals("F")) {
			System.out.println("0.0");
		}
	}

}
