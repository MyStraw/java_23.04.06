package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _30089_새로운문자열만들기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder result = new StringBuilder();

		for (int i = 0; i < T; i++) {
			String S = br.readLine();
			String X = findShortestX(S);
			result.append(X).append("\n");
		}

		System.out.print(result.toString());
	}

	private static String findShortestX(String S) {
		StringBuilder sb = new StringBuilder(S);
		String reverse = sb.reverse().toString();
		sb.reverse();

		int len = S.length();
		for (int i = 0; i < len; i++) {
			if (S.substring(i).equals(reverse.substring(0, len - i))) {
				return S + reverse.substring(len - i);
			}
		}
		return S + reverse; 
	}

}
