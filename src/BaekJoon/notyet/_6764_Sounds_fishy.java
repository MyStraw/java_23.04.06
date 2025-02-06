package BaekJoon.notyet;

import java.util.Scanner;

public class _6764_Sounds_fishy {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] finder = new int[4];

		for (int i = 0; i < 4; i++) {
			finder[i] = sc.nextInt();
		}

		if (finder[0] < finder[1] && finder[1] < finder[2] && finder[2] < finder[3]) {
			System.out.println("Fish Rising");
		} else if (finder[0] > finder[1] && finder[1] > finder[2] && finder[2] > finder[3]) {
			System.out.println("Fish Diving");
		} else if (finder[0] == finder[1] && finder[1] == finder[2] && finder[2] == finder[3]) {
			System.out.println("Fish At Constant Depth");
		} else {
			System.out.println("No Fish");
		}

	}

}
