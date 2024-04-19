package BaekJoon.notyet;

import java.util.Scanner;

public class _30676_이별은무슨색일까 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int phi = sc.nextInt();

		if (phi <= 780 && phi >= 620) {
			System.out.println("Red");
		} else if (phi >= 590) {
			System.out.println("Orange");
		} else if (phi >= 570) {
			System.out.println("Yellow");
		} else if (phi >= 495) {
			System.out.println("Green");
		} else if (phi >= 450) {
			System.out.println("Blue");
		} else if (phi >= 425) {
			System.out.println("Indigo");
		} else if (phi >= 380) {
			System.out.println("Violet");
		}

	}

}
