package BaekJoon.notyet;

import java.math.BigInteger;
import java.util.Scanner;

public class _1676_팩토리얼0의개수2 { // 미완
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		BigInteger fact = BigInteger.ONE;

		// 팩토리얼 계산
		for (int i = 2; i <= N; i++) {
			fact = fact.multiply(BigInteger.valueOf(i));
		}

		String factoStr = fact.toString();

		int count = 0;
		// 뒤에서부터 0이 아닌 숫자가 나올 때까지 0의 개수 세기
		for (int i = factoStr.length() - 1; i >= 0; i--) {
			if (factoStr.charAt(i) == '0') {
				count++;
			} else {
				break;
			}
		}

		System.out.println(count);
	}

}
