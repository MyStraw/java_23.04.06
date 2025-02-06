package BaekJoon.notyet;

import java.util.Scanner;

public class _14564_두부게임 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int A = sc.nextInt();
		sc.nextLine();

		int[] seat = new int[N];
		for (int i = 0; i < N; i++) {
			seat[i] = i + 1;
		}

		int currentHost = A - 1; 
		int half = M / 2;

		while (true) {
			int call = sc.nextInt();

			if (call == half + 1) {
				System.out.println(0);
				break;
			}

			int idx = (currentHost + call - (half + 1) + N) % N;
			System.out.println(seat[idx]);

			currentHost = idx;
		}		
	}

}
