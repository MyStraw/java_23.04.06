package BaekJoon.notyet;

import java.util.Scanner;

public class _20215_cutting_corners {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int w = sc.nextInt();
		int h = sc.nextInt();

		double diagonal = Math.sqrt(w * w + h * h);
		double perimeter = w + h;

		System.out.println(perimeter - diagonal);
	}

}
