package BaekJoon.notyet;

import java.util.Scanner;

public class _17010_Time_to_Decompress {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int L = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < L; i++) {
			int N = sc.nextInt();
			char C = sc.next().charAt(0);

			for (int j = 0; j < N; j++) {
				System.out.print(C);
			}

			System.out.println();
		}
	}
}
