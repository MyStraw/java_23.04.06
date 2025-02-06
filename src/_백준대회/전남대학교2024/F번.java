package _백준대회.전남대학교2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class F번 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		String[] letters = new String[N];
		for (int i = 0; i < N; i++) {
			letters[i] = br.readLine();
		}

		int K = Integer.parseInt(br.readLine());
		String[] names = new String[K];
		for (int i = 0; i < K; i++) {
			names[i] = br.readLine();
		}

		List<String> alwaysAppear = new ArrayList<>();
		for (String name : names) {
			if (checkAlwaysAppear(letters, name, M)) {
				alwaysAppear.add(name);
			}
		}

		System.out.println(alwaysAppear.size());
		for (String name : names) {
			System.out.println(alwaysAppear.contains(name) ? "Yes" : "No");
		}
	}

	private static boolean checkAlwaysAppear(String[] letters, String name, int M) {
		int N = letters.length;
		StringBuilder fullText = new StringBuilder();
		for (String letter : letters) {
			fullText.append(letter);
		}

		// Check if name appears in any continuous M+1 letters
		for (int i = 0; i <= N - M - 1; i++) {
			StringBuilder window = new StringBuilder();
			for (int j = i; j < i + M + 1; j++) {
				window.append(letters[j]);
			}
			if (!window.toString().contains(name)) {
				return false;
			}
		}

		// Check if name is split between first and last letters
		StringBuilder edgeCase = new StringBuilder(letters[N - 1]).append(letters[0]);
		if (!edgeCase.toString().contains(name)) {
			return false;
		}

		return true;
	}

}
