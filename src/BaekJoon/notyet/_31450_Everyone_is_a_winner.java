package BaekJoon.notyet;

import java.util.Scanner;

public class _31450_Everyone_is_a_winner {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();
		int K = sc.nextInt();
		
		if (M%K == 0) {
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}
	}

}
