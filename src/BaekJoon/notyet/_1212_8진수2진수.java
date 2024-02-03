package BaekJoon.notyet;

import java.util.Scanner;

public class _1212_8진수2진수 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String oct = sc.nextLine();

		String binary = Integer.toBinaryString(Integer.parseInt(oct, 8));

		System.out.println(binary);

	}
}
