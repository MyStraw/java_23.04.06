package _스터디_자료구조;

import java.util.Scanner;

public class _6_0_시간복잡도 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = 3;
		int S = 4;
		int count = 0;
		for (int i = 1; i <= N; i++) {
			for ( int j = 1; j<=N ; j++) {
				if (i + j <=S) {
					count++;
				}				
			}			
		}	
		System.out.println(count);
		
	}

}
