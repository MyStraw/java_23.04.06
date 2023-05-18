package _스터디;

import java.util.Scanner;

class _5월20일_하노이탑 {
	static Scanner sc = new Scanner(System.in);
	public static int N = sc.nextInt();

	static int hanoi(int i) {
		if (i == 1)
			return 1;
		else
			return 2 * hanoi(i - 1) + 1;
	}

	public static void main(String[] args) {

		int hano[] = new int[N];
		hano[0] = 1;

		for (int i = 0; i < N - 1; i++) {

			hano[i + 1] = 2 * hano[i] + 1;
		}

		System.out.println(hano[N - 1]);
		System.out.println(hanoi(N));

	}
	
	static int hanoi2(int n, int x, int y) {
		return n;
		
	}

}
