package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class _15723_n단논법 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		Map<String, String> samdan = new HashMap<>();

		for (int i = 0; i < n; i++) {
			String[] str = br.readLine().split(" is ");
			samdan.put(str[0], str[1]);
		}

		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			String[] result = br.readLine().split(" is ");
			String a = result[0];
			String b = result[1];

			if (can(samdan, a, b)) {
				sb.append("T\n");
			} else {
				sb.append("F\n");
			}
		}

		System.out.println(sb.toString());
	}

	private static boolean can(Map<String, String> samdan, String a, String b) {
		while (samdan.containsKey(a)) {
			a = samdan.get(a);
			if (a.equals(b)) {
				return true;
			}
		}
		return false;
	}

}
