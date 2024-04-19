package BaekJoon.notyet;

import java.util.Scanner;

public class _4696_st_lves {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			double w = sc.nextDouble();
			if (w == 0)
				break;
			
			double total = 1 + w + Math.pow(w, 2) + Math.pow(w, 3) + Math.pow(w, 4);

			System.out.printf("%.2f\n", total);
		}
	}
}