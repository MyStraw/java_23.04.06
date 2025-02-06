package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _10769_행복한지슬픈지 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		int happyCount = 0;
		int sadCount = 0;

		for (int i = 0; i < input.length() - 2; i++) {
			String emoticon = input.substring(i, i + 3);
			if (emoticon.equals(":-)")) {
				happyCount++;
			} else if (emoticon.equals(":-(")) {
				sadCount++;
			}
		}

		if (happyCount == 0 && sadCount == 0) {
			System.out.println("none");
		} else if (happyCount == sadCount) {
			System.out.println("unsure");
		} else if (happyCount > sadCount) {
			System.out.println("happy");
		} else {
			System.out.println("sad");
		}
	}

}
