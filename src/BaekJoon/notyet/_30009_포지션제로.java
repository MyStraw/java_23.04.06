package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _30009_포지션제로 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		int[] T = new int[N];

		int zeroCount = 0;
		int lineCount = 0;

		for (int i = 0; i < N; i++) {
			T[i] = Integer.parseInt(br.readLine());
			if (X + R == T[i] || X - R == T[i]) {
				lineCount++;
			} else if (X - R < T[i] && T[i] < X + R) {
				zeroCount++;
			}
		}
		System.out.print(zeroCount + " " + lineCount);

	}

}
