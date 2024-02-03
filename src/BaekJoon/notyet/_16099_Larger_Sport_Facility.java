package BaekJoon.notyet;

import java.util.Scanner;

public class _16099_Larger_Sport_Facility {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		
		int testCases = sc.nextInt();

		for (int i = 0; i < testCases; i++) {
			
			long lt = sc.nextLong();
			long wt = sc.nextLong();
			long le = sc.nextLong();
			long we = sc.nextLong();

			
			long paris = lt * wt;
			long eu = le * we;

			
			if (paris > eu) {
				System.out.println("TelecomParisTech");
			} else if (eu > paris) {
				System.out.println("Eurecom");
			} else {
				System.out.println("Tie");
			}
		}
	}
}
