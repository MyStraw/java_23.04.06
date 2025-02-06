package BaekJoon.notyet;

import java.util.Scanner;

public class _9020_골드바흐의추측 {
	static int T, num;

	static boolean isPrimeNum(int num) {
		for (int i = 2; i < num; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

	static void Answer(int num) {
		int length = num / 2;

		for (int i = 0; i < length; i++) {
			int temp1 = length - i;
			if (isPrimeNum(temp1)) {
				if (isPrimeNum(num - temp1)) {
					System.out.println(temp1 + " " + (num - temp1));
					return;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			num = sc.nextInt();			
			Answer(num);
		}	
	}
}
