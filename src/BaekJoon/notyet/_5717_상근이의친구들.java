package BaekJoon.notyet;

import java.util.Scanner;

public class _5717_상근이의친구들 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			int M = sc.nextInt();
			int F = sc.nextInt();			
			if(M + F == 0) {
				break;			
			}
			System.out.println(M + F);
		}		
	}
}
