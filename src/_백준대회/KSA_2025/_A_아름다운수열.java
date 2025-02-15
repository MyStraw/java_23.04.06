package _백준대회.KSA_2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _A_아름다운수열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());

			sb.append("YES\n");

			for (int j = 1; j <= N; j++) {
				sb.append(j);
				if (j != N) {
					sb.append(" ");
				}
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());

	}

}
