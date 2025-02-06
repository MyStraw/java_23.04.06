package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _26007_Codepowers {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		int[] A = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		int[] rating = new int[N + 1];
		rating[0] = X;

		for (int i = 1; i <= N; i++) {
			rating[i] = rating[i - 1] + A[i - 1];
		}

		int[] prefixCount = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			prefixCount[i] = prefixCount[i - 1] + (rating[i] < K ? 1 : 0);
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());

			int count = prefixCount[r - 1] - prefixCount[l - 1];
			bw.write(count + "\n");
		}
		bw.flush();
		bw.close();
	}

}
