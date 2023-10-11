package BaekJoon.notyet;

import java.util.Scanner;

public class _1676_팩토리얼0의개수 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int fact = 1;

		for (int i = 1; i <= N; i++) {
			fact *= i;
		}
		String facto = Integer.toString(fact);

		int count = 0;
		for (int i = 0; i < facto.length(); i++) {
			if (i == 0 && fact % 10 == 0) {
				if (fact % 10 == 0) {
					fact /= 10;
					count++;
					continue;
				} else if (fact % 10 != 0) {
					break;
				}
			} 
			
			
			
			if (i == 0 && fact % 10 != 0) {
				count++;
				fact /= 10;
				if (fact % 10 == 0) {
					break;
				}
			}
		}
		System.out.println(count);
	}

}
