package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _11659_구간합구하기4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] num = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int k = 0; k < N; k++) {
			num[k] = Integer.parseInt(st.nextToken());
		}

		for (int k = 0; k < M; k++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int total = 0;

			for (int l = i - 1; l <= j - 1; l++) {
				total += num[l];
			}
			bw.write(String.valueOf(total));
			bw.newLine();

		}
		bw.flush();
		bw.close();
	}

}
