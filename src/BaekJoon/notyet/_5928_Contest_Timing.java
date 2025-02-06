package BaekJoon.notyet;

import java.util.Scanner;

public class _5928_Contest_Timing {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int D = sc.nextInt(); 
		int H = sc.nextInt(); 
		int M = sc.nextInt();
		
		int startD = 11;
		int startH = 11;
		int startM = 11;

		int start = startD * 24 * 60 + startH * 60 + startM;
		int end = D * 24 * 60 + H * 60 + M;

	
		if (end < start) {
			System.out.println(-1);
		} else {			
			int totalMinutes = end - start;
			System.out.println(totalMinutes);
		}
	
	}

}
