package BaekJoon.notyet;

import java.util.Scanner;

public class _15059_Hard_choice {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int Ca = sc.nextInt();
		int Ba = sc.nextInt();
		int Pa = sc.nextInt();
	
		int Cr = sc.nextInt();
		int Br = sc.nextInt();
		int Pr = sc.nextInt();
	
		int chicken = Math.max(0, Cr - Ca);
		int beef = Math.max(0, Br - Ba);
		int pasta = Math.max(0, Pr - Pa);

		int total = chicken + beef + pasta;

		System.out.println(total);
	}

}
