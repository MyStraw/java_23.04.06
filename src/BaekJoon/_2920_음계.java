package BaekJoon;

import java.util.Scanner;

public class _2920_음계 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 8; i++) {
			sb.append(Character.getNumericValue(sc.nextInt()));
		}
		
		System.out.println(sb);

	}

}
