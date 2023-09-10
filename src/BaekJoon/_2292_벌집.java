package BaekJoon;

import java.util.Scanner;

public class _2292_벌집 {
	public static void main(String[] args) {

//		1
//		2,3,4,5,6,7 => 6
//		8,9,10,11,12,13,14,15,16,17,18,19 => 12
//		20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37 => 18
//		38~61 => 24

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		for (int i = 1; i <= 100000; i++) {
			if (N == 1) {
				System.out.println(1);
				break;
			}

			if (1 < N && N <= 7) {
				System.out.println(2);
				break;
			}
			if (1 + 3 * i * (i + 1) <= N && N <= 1 + 3 * (i + 1) * (i + 2)) {
				System.out.println(i + 2);
				break;

			}

		}

	}

}
