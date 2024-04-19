package BaekJoon.notyet;

import java.util.Scanner;

public class _20492_세금 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int A = (int) (N * 0.78);
		int B = (int) (N * 0.956);

		System.out.println(A + " " + B);
	}

}
