package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _5637_가장긴단어 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String longest = "";
		StringBuilder sb = new StringBuilder();

		String line;
		while ((line = reader.readLine()) != null) {
			if (line.contains("E-N-D")) {
				sb.append(line, 0, line.indexOf("E-N-D"));
				break;
			}
			sb.append(line).append(" ");
		}

		String input = sb.toString();
		StringBuilder wordSb = new StringBuilder();

		for (char c : input.toCharArray()) {
			if (Character.isLetter(c) || c == '-') {
				wordSb.append(c);
			} else {
				if (wordSb.length() > longest.length()) {
					longest = wordSb.toString();
				}
				wordSb.setLength(0);
			}
		}

		if (wordSb.length() > longest.length()) {
			longest = wordSb.toString();
		}

		System.out.println(longest.toLowerCase());
	}

}
