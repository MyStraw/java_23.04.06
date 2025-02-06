package _백준대회.국민대와중앙대_2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A번_햄버거 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] abcd = br.readLine().split(" ");
		int a = Integer.parseInt(abcd[0]);
		int b = Integer.parseInt(abcd[1]);
		int c = Integer.parseInt(abcd[2]);
		int d = Integer.parseInt(abcd[3]);
		String s = br.readLine();

		int[] count = new int[4];
		for (char ch : s.toCharArray()) {
			if (ch == 'a')
				count[0]++;
			else if (ch == 'b')
				count[1]++;
			else if (ch == 'c')
				count[2]++;
			else if (ch == 'd')
				count[3]++;
		}
		if (s.charAt(0) != 'a' || s.charAt(n - 1) != 'a') {
			System.out.println("No");
			return;
		}

		for (int i = 1; i < n; i++) {
			if (s.charAt(i) == s.charAt(i - 1)) {
				System.out.println("No");
				return;
			}
		}

		if (count[0] > a || count[1] > b || count[2] > c || count[3] > d) {
			System.out.println("No");
			return;
		}

		System.out.println("Yes");
	}

}
