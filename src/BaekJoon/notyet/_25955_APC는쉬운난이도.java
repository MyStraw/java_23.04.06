package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _25955_APC는쉬운난이도 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		String[] problem = new String[N];
		for (int i = 0; i < N; i++) {
			problem[i] = st.nextToken();
		}

		int wrongIdx = -1;
		for (int i = 1; i < N; i++) {
			if (compare(problem[i - 1], problem[i]) > 0) {
				if (wrongIdx == -1) {
					wrongIdx = i;
				} else {
					System.out.println("KO");
					System.out.println(problem[i] + " " + problem[wrongIdx - 1]);
					return;
				}
			}
		}

		if (wrongIdx == -1) {
			System.out.println("OK");
		} else {
			System.out.println("KO");
			System.out.println(problem[wrongIdx] + " " + problem[wrongIdx - 1]);
		}
	}

	private static int compare(String a, String b) {
		char tierA = a.charAt(0);
		char tierB = b.charAt(0);

		if (tierA != tierB) {
			return "BSGPD".indexOf(tierA) - "BSGPD".indexOf(tierB);
		}

		int levelA = Integer.parseInt(a.substring(1));
		int levelB = Integer.parseInt(b.substring(1));

		return levelB - levelA;

	}

}
