package BaekJoon.notyet;

import java.util.Scanner;

public class _1094_막대기 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int X = sc.nextInt();

		int[] stick = { 64, 32, 16, 8, 4, 2, 1 };

		int count = 0;		

		for (int i = 0; i < 7; i++) {
			if (X - stick[i] == 0) {
				count++;
				break;						
			} else if (X - stick[i] >= 0) {
				X = X - stick[i];				
				count++;				
			}
		}
		System.out.println(count);
	}
}