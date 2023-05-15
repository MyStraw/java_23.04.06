package _스터디;

import java.util.Scanner;

public class _5월20일_하노이탑 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int hano[] = new int[N];
		hano[0] = 1;
		
		for (int i = 0; i < N-1; i++) {
			
			hano[i+1] = 2*hano[i] +1;
		System.out.println(hano[i]);
			
		}

	}

}
