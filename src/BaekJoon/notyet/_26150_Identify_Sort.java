package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class _26150_Identify_Sort {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<String[]> problems = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			problems.add(br.readLine().split(" "));
		}

		problems.sort(Comparator.comparingInt(o -> Integer.parseInt(o[1])));

		StringBuilder result = new StringBuilder();
		for (String[] p : problems) {
			String s = p[0];
			int d = Integer.parseInt(p[2]) - 1;
			char c = s.charAt(d);
			result.append(Character.toUpperCase(c));
		}

		System.out.println(result);
	}

}
