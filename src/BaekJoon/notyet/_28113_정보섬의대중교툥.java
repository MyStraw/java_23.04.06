package BaekJoon.notyet;

import java.util.Scanner;

public class _28113_정보섬의대중교툥 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int A = sc.nextInt();
		int B = sc.nextInt();
	
		
		if (A == B) {
			System.out.println("Anyghing");
			
		}
		else if (A>B) {
			System.out.println("Subway");
		}
		else if (B>A ) {
			System.out.println("Bus");
		}
	}

}
