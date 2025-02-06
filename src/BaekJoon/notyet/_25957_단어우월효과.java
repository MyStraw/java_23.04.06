package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _25957_단어우월효과 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		Map<String, String> map = new HashMap<>();

		for (int i = 0; i < n; i++) {
			String word = br.readLine();
			String key = createKey(word);
			map.put(key, word);
		}

		int m = Integer.parseInt(br.readLine());
		String[] scrambledWords = br.readLine().split(" ");

		for (String scrambled : scrambledWords) {
			String key = createKey(scrambled);
			sb.append(map.get(key)).append(" ");
		}

		System.out.println(sb.toString().trim());
	}

	private static String createKey(String word) {
		char[] chars = word.toCharArray();
		if (chars.length > 2) {
			Arrays.sort(chars, 1, chars.length - 1);
		}
		return word.charAt(0) + new String(chars) + word.charAt(word.length() - 1);
	}

}
