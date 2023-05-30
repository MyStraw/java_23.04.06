package _스터디;

import java.util.Scanner;

public class 예진이꺼 {

	static int k;
	static int[] s;
	static int[] res;

	public static void choice(int gae) {
		if (gae == 6) {
			for (int i = 0; i < 6; i++) {
				System.out.print(s[i] + " ");
			}
			System.out.println();
		} else {
			for (int i = 1; i < k; i++) {
				res[gae] = s[i];
				choice(gae + 1);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			k = sc.nextInt();
			if (k == 0) {
				break;
			}
			s = new int[k];
			res = new int [k];
			for (int i = 0; i < k; i++) {
				s[i] = sc.nextInt();
			}

			choice(0);
		}

		sc.close();

	}

}
