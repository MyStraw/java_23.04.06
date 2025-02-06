package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _3181_줄임말만들기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] ignore = { "i", "pa", "te", "ni", "niti", "a", "ali", "nego", "no", "ili" };
		String input = br.readLine();

		StringTokenizer st = new StringTokenizer(input);
		StringBuilder sb = new StringBuilder();
		boolean first = true;

		while (st.hasMoreTokens()) {
			String word = st.nextToken();
			if (first || !contains(ignore, word)) {
				sb.append(Character.toUpperCase(word.charAt(0)));
				first = false;
			}
		}

		System.out.println(sb.toString());
	}

	private static boolean contains(String[] arr, String target) {
		for (String s : arr) {
			if (s.equals(target)) {
				return true;
			}
		}
		return false;
	}

}
