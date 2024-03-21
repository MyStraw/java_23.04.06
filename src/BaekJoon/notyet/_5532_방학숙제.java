package BaekJoon.notyet;

import java.util.Scanner;

public class _5532_방학숙제 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int L = sc.nextInt();
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int D = sc.nextInt();

		int ko = 0;
		int math = 0;

		for (int i = 1; i <= 100; i++) {
			if (A - C * i <= 0) {
				ko++;
				break;
			} else if (A - C * i > 0) {
				ko = i;
			}
		}
		for (int i = 1; i <= 100; i++) {
			if (B - D * i <= 0) {
				math++;
				break;
			} else if (B - D * i > 0) {
				math = i;
			}
		}		

		if (ko >= math) {
			System.out.println(L - ko);
		} else {
			System.out.println(L - math);
		}

	}

}
