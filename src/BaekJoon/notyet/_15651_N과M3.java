package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class _15651_N과M3 {
	static int N, M;
	static int[] dfs;

	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		dfs = new int[M];

		backtrack(0);
		bw.flush();
		bw.close();
		br.close();
	}

	static void backtrack(int count) throws IOException {
		if (count == M) {
			for (int num : dfs) {
				bw.write(num + " ");
			}
			bw.newLine();
			return;
		}

		for (int i = 1; i <= N; i++) {
			dfs[count] = i;
			backtrack(count + 1);
		}
	}
}
