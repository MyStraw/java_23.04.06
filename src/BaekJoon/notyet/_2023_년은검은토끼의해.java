package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2023_년은검은토끼의해 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int count = 0;
		String target = "2023";

		for (int i = 2023; i <= n; i++) {
			String s = Integer.toString(i);
			if (s.length() >= 4 && isWinningTicket(s, target)) {
				count++;
			}
		}

		System.out.println(count);
	}

	private static boolean isWinningTicket(String s, String target) {
		int tIdx = 0;
		for (char c : s.toCharArray()) {
			if (c == target.charAt(tIdx)) {
				tIdx++;
				if (tIdx == target.length()) {
					return true;
				}
			}
		}
		return false;
	}

}
