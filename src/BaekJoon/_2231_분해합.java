package BaekJoon;

import java.util.Scanner;

public class _2231_분해합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		String N_String = Integer.toString(N);

		char[] C = N_String.toCharArray();
		int [] I = new int [N_String.length()];
	
		for (int i = 0; i < N_String.length(); i++) {
			I[i] = (int)C[i] - '0';
		}
		
		
	}
}
