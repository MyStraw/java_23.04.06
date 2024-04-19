package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class _14425_문자열집합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		HashSet<String> zip = new HashSet<>();

		for (int i = 0; i < N; i++) {
			zip.add(br.readLine());
		}

		int count = 0;
		for (int i = 0; i < M; i++) {
			String inspect = br.readLine();
			if (zip.contains(inspect)) {
				count++;
			}
		}
		System.out.println(count);
	}
}
