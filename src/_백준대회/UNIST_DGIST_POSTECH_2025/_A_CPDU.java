package _백준대회.UNIST_DGIST_POSTECH_2025;

import java.util.Scanner;

public class _A_CPDU {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			String s = sc.next();
			if (s.charAt(0) == 'C')
				cnt++;
		}
		System.out.println(cnt);
	}

}
