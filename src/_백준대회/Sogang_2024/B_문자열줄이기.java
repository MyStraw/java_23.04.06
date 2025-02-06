package _백준대회.Sogang_2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_문자열줄이기{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		char[] s = br.readLine().toCharArray();
		boolean[] removed = new boolean[N];

		ArrayList<Integer>[] positions = new ArrayList[26];
		for (int i = 0; i < 26; i++) {
			positions[i] = new ArrayList<>();
		}

		for (int i = 0; i < N; i++) {
			positions[s[i] - 'a'].add(i);
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < 26; j++) {
				if (!positions[j].isEmpty()) {
					while (!positions[j].isEmpty() && removed[positions[j].get(0)]) {
						positions[j].remove(0);
					}
					if (!positions[j].isEmpty()) {
						removed[positions[j].get(0)] = true;
						break;
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			if (!removed[i]) {
				sb.append(s[i]);
			}
		}

		System.out.println(sb);
	}
}
