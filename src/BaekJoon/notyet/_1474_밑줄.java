package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1474_밑줄 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);

		String[] word = new String[N];
		int totalLen = 0;
		for (int i = 0; i < N; i++) {
			word[i] = br.readLine();
			totalLen += word[i].length();
		}

		int defaultLen = (M - totalLen) / (N - 1);
		int r = (M - totalLen) % (N - 1);
	
		StringBuilder result = new StringBuilder();
		result.append(word[0]);

		for (int i = 1; i < N; i++) {		
			if (Character.isLowerCase(word[i].charAt(0)) && r > 0) {
				result.append("_".repeat(defaultLen + 1));
				r--;
			} else if (i + r == N) {
				result.append("_".repeat(defaultLen + 1));
				r--;
			} else {
				result.append("_".repeat(defaultLen));
			}
			result.append(word[i]);
		}
	
		System.out.println(result.toString());
	}

}
