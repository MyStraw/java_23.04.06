package _백준대회.중앙대학교2024;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class B1_현권이와신기한수열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int su[] = new int[N + 1];

		su[0] = 0;

		Set<Integer> set = new HashSet<>();
		set.add(0);

		for (int i = 1; i <= N; i++) {
			su[i] = su[i - 1] - i;

			if (su[i] < 0 || set.contains(su[i])) {
				su[i] = su[i - 1] + i;
			}
			set.add(su[i]);
		}
		System.out.println(su[N]);

	}

}
