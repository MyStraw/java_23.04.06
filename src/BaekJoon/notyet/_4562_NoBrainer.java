package BaekJoon.notyet;

import java.util.Scanner;

public class _4562_NoBrainer {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N =sc.nextInt();
		
		for (int i = 0; i<N;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			if(x>=y) {
				System.out.println("MMM BRAINS");
				
			}
			else
				System.out.println("NO BRAINS");
		}
		
	}
}
