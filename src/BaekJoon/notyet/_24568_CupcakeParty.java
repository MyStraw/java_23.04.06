package BaekJoon.notyet;

import java.util.Scanner;

public class _24568_CupcakeParty {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int R = sc.nextInt();
		int S = sc.nextInt();
		
		int total = R *8 + S * 3;		
		
		int howManyLeft = total - 28;
		
		System.out.println(howManyLeft);
		
	}

}
