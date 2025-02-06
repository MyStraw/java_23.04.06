package BaekJoon.notyet;

import java.util.Scanner;

public class _19944_뉴비의기준은뭘까 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		if (M == 1 || M == 2) {
			System.out.println("NEWBIE!");
		} else if (N >= M) {
			System.out.println("OLDBIE!");
		}else
			System.out.println("TLE!");
	}

}
