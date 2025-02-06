package BaekJoon.notyet;

import java.util.Scanner;

public class _4375_4 { //최종. 나머지 연산을 이용.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNextInt()) {
			int n = sc.nextInt();
			long i = 1;
			int count = 1;
		    while (i % n != 0) {
	            i = (i * 10 + 1) % n; // 나머지 연산을 사용하여 큰 수를 다루지 않음
	            count++; // 자릿수 증가
	        }
			System.out.println(count);
		}
	}
}
