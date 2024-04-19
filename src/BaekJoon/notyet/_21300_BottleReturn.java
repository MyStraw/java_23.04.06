package BaekJoon.notyet;

import java.util.Scanner;

public class _21300_BottleReturn {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int total = 0;
		
		for (int i = 0 ; i<6; i++) {
			int beer = sc.nextInt();			
			total += beer * 5;
		}
		
		System.out.println(total);
		
	}

}
