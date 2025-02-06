package BaekJoon.notyet;

import java.util.Scanner;

public class _1338_알수없는번호 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long left = sc.nextLong();
		long right = sc.nextLong();

		long x = sc.nextLong();
		long y = sc.nextLong();

		if (left > right) {
			long temp = left;
			left = right;
			right = temp;
		}

		if (x == 0 || y < 0 || y >= Math.abs(x)) {
			System.out.println("Unknwon Number");
			return;
		}

		long absX = Math.abs(x);

		
		long firstNum;
		if (x > 0) {
			firstNum = left + (y - left % x + x) % x;
		} else {
			firstNum = left + (y - (left % absX + absX) % absX + absX) % absX;
		}

		if (firstNum > right) {
			System.out.println("Unknwon Number");
		} else if (firstNum + absX  > right) {
			System.out.println(firstNum);
		} else {
			System.out.println("Unknwon Number");
		}
	}

}
