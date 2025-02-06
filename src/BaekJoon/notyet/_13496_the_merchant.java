package BaekJoon.notyet;

import java.util.Scanner;

public class _13496_the_merchant {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();

		for (int i = 1; i <= K; i++) {
			int n = sc.nextInt();
			int s = sc.nextInt();
			int d = sc.nextInt();

			int total = 0; 

			for (int j = 0; j < n; j++) {
				int di = sc.nextInt(); 
				int vi = sc.nextInt();

				
				if (di <= s * d) {
					total += vi; 
				}
			}
			
			System.out.println("Data Set " + i + ":");
			System.out.println(total);
			System.out.println();
		}		
	}
}
