package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _21318_피아노체조 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] diff = new int[N];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			diff[i] = Integer.parseInt(st.nextToken());
		}

		int Q = Integer.parseInt(br.readLine());
		int[] mistakeSum = new int[N + 1];

		for (int i = 1; i < N; i++) {
			mistakeSum[i] = mistakeSum[i - 1];
			if (diff[i - 1] > diff[i]) {
				mistakeSum[i]++;
			}
		}
		mistakeSum[N] = mistakeSum[N - 1];

		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			bw.write((mistakeSum[y] - mistakeSum[x]) + "\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}

}
