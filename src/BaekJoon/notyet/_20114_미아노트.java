package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _20114_미아노트 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());

		char[][] mia = new char[H][N * W];

		char[] result = new char[N];

		for (int i = 0; i < H; i++) {
			mia[i] = br.readLine().toCharArray();
		}
		
		Arrays.fill(result, '?');

		for (int i = 0; i < mia.length; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < W; k++) {
					if (mia[i][(j * W) + k] != '?') {
						result[j] = mia[i][(j * W) + k];
					}
				}
			}
		}
		for (int i = 0; i < N; i++) {
			System.out.print(result[i]);
		}
	}
}
