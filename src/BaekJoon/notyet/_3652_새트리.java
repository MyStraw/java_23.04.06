package BaekJoon.notyet;

import java.util.Scanner;

public class _3652_새트리 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] frac = sc.nextLine().split("/");
		int ja = Integer.parseInt(frac[0]); // 분자
		int mo = Integer.parseInt(frac[1]); // 분모

		StringBuilder path = new StringBuilder();

		while (ja != mo) {
			if (ja > mo) {
				path.append("R");
				int temp = mo;
				mo = ja - mo;
				ja = temp;
			} else {
				path.append("L");
				int temp = ja;
				ja = mo - ja;
				mo = temp;
			}
		}

		System.out.println(path);
	}

}
