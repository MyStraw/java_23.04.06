package BaekJoon.notyet;

import java.util.Scanner;

public class _6749_Next_in_line {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int Y = sc.nextInt();
		int M = sc.nextInt();
		
		int first = M + (M-Y);
		
		System.out.println(first);
	}

}
