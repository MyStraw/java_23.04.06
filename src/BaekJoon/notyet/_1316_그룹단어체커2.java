package BaekJoon.notyet;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class _1316_그룹단어체커2 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int count = 0;
		for (int i = 0; i < N; i++) {
			Set<Character> cc = new HashSet<>();
			String group = sc.next();
			char[] con = group.toCharArray();
			for (int j = 0; j < con.length - 1; j++) {
				cc.add(con[j]);
				if (con[j + 1] == con[j]) {
					continue;
				} else if (con[j + 1] != con[j] && !cc.contains(con[j + 1])) {
					cc.add(con[j + 1]);
				} else if (con[j + 1] != con[j] && cc.contains(con[j + 1])) {
					count++;
					break;
				}
			}
		}
		System.out.println(N - count);
	}
}