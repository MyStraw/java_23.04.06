package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _11256_사탕 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int J = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());

			int[] box = new int[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int R = Integer.parseInt(st.nextToken());
				int C = Integer.parseInt(st.nextToken());
				box[i] = R * C;
			}

			Arrays.sort(box);
			int count = 0;
			int candy = J;

			for (int i = N - 1; i >= 0; i--) {
				if (candy <= 0)
					break;
				candy -= box[i];
				count++;
			}

			System.out.println(count);
		}
	}

}
