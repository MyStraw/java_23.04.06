package BaekJoon.notyet;

import java.util.Scanner;

public class _25495_에어팟 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int connected = 0;
		int prv = 0;
		int battery = 0;

		while (N-- > 0) {
			int x = sc.nextInt();
			if (x == connected) {
				battery += prv * 2;
				prv *= 2;
			} else {
				connected = x;
				battery += 2;
				prv = 2;
			}

			if (battery > 99) {
				connected = 0;
				prv = 0;
				battery = 0;
			}
		}

		System.out.println(battery);
	}
}
