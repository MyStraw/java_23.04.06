package BaekJoon.notyet;

import java.util.Scanner;

public class _32326_ConveyouBeltSushi {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int red = sc.nextInt();
		int green = sc.nextInt();
		int blue = sc.nextInt();

		int total = red * 3 + green * 4 + blue * 5;
		System.out.println(total);
	}

}
