package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class _11478_서로다른부분문자열의개수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		Set<String> set = new HashSet<>();		
		for (int i = 1; i <= S.length(); i++) {
			for (int j = 0; j < S.length() - i + 1; j++) {
				String sec = S.substring(j, j + i);
				if (!set.contains(sec)) {
					set.add(sec);
				}
			}
		}
		System.out.println(set.size());
	}
}