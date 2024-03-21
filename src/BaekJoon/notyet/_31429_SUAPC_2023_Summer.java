package BaekJoon.notyet;

import java.util.Scanner;

public class _31429_SUAPC_2023_Summer {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[][] data = { {0,0}, { 12, 1600 }, { 11, 894 }, { 11, 1327 }, { 10, 1311 }, { 9, 1004 }, { 9, 1178 }, { 9, 1357 },
				{ 8, 837 }, { 7, 1055 }, { 6, 556 }, { 6, 773 } };

		int N = sc.nextInt();

		System.out.println(data[N][0] + " " + data[N][1]);

	}

}
