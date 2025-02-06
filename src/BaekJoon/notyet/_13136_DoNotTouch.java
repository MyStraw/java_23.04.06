package BaekJoon.notyet;

import java.util.Scanner;

public class _13136_DoNotTouch {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		long R = sc.nextInt();
		long C = sc.nextInt();
		long N = sc.nextInt();
	
		long row = (R + N - 1) / N;
		long col = (C + N - 1) / N;
		long total = row * col;	
		System.out.println(total);

	}

}
