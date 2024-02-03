package BaekJoon.notyet;

import java.util.Scanner;

public class _27389_Metronome {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		double rot = (double)n/4;
		
		System.out.printf("%.2f\n", rot);
	}

}
