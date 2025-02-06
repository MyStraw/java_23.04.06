package _백준대회.전남대학교2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class A번_더블팰린드롬 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Set<String> halfStrings = new HashSet<>();

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			if (isPalindrome(s)) {
				halfStrings.add(s.substring(0, s.length() / 2));
			}
		}

		int count = halfStrings.size();		
		long result = (long) count * (count - 1);

		System.out.println(result);
	}

	private static boolean isPalindrome(String s) {
		int left = 0, right = s.length() - 1;
		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
}
