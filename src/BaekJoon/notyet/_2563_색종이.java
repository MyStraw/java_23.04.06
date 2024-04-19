package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2563_색종이 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		boolean[][] paper = new boolean[100][100];

		for (int i = 0; i < paper.length; i++) {
			Arrays.fill(paper[i], false);
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			for (int j = y; j < y + 10; j++) {
				Arrays.fill(paper[j], x, x + 10, true);
			}
		}
		int count = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (paper[i][j]) {
					count++;
				}
			}
		}		
		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
		br.close();
	}
}
