package BaekJoon;

import java.util.Arrays;
import java.util.Scanner;

public class _2309_일곱난쟁이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int key[] = new int[9];
		int total = 0;

		for (int i = 0; i < 9; i++) {
			key[i] = sc.nextInt();
			total += key[i];
		}

		Arrays.sort(key);

		for (int i = 0; i < 9; i++) {
			for (int j = i + 1; j < 9; j++) {
				if (total - key[i] - key[j] == 100) {
					for (int k = 0; k < 9; k++) {
						if (k != i && k != j) {
							System.out.println(key[k]);
						}
					}
					System.exit(0);
				}
			}
		}
	}
}
