package _백준대회.Hello_AlKon_2025;

import java.util.Scanner;

public class _B_비밀번호 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();

		if (K == 1 || K == 3 || K == 7 || K == 9 || K == 5) {
			System.out.println(8);
		} else if (K == 2 || K == 4 || K == 6 || K == 8) {
			System.out.println(0);
		}
	}

}
