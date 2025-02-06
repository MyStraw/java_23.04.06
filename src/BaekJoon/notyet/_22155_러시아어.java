package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _22155_러시아어 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int j = 0; j < n; j++) {
			String[] input = br.readLine().split(" ");
			int i = Integer.parseInt(input[0]);
			int f = Integer.parseInt(input[1]);

			if ((i <= 1 && f <= 2) || (i <= 2 && f <= 1)) {
				sb.append("Yes").append("\n");
			} else {
				sb.append("No").append("\n");
			}
		}

		System.out.print(sb.toString());
	}

}
