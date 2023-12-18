package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _11659_구간합구하기4_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int num = 0;
		int[] stack = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int k = 0; k < N; k++) {
			num = Integer.parseInt(st.nextToken());
			if (k == 0) {
				stack[k] = num;
			} else {
				stack[k] = stack[k - 1] + num;
			}
		}
		for (int k = 0; k < M; k++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());

			if (i > 1) {
				int result = stack[j - 1] - stack[i - 2];
				bw.write(String.valueOf(result));
				bw.newLine();
			} else if (i == 1) {
				int result = stack[j - 1];
				bw.write(String.valueOf(result));
				bw.newLine();
			}
		}
		bw.flush();
		bw.close();
	}
}
