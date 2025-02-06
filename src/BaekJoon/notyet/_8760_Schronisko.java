package BaekJoon.notyet;

import java.util.Scanner;

public class _8760_Schronisko {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		int Z = sc.nextInt();
	
		for (int t = 0; t < Z; t++) {
			int W = sc.nextInt();
			int K = sc.nextInt();
			
			int maxTourists = (W * K) / 2;
		
			System.out.println(maxTourists);
		}	
	}
}