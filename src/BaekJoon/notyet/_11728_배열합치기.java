package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _11728_배열합치기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int NNMM[] = new int[N + M];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {

			NNMM[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = N; i < N + M; i++) {

			NNMM[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(NNMM);

		for (int i = 0; i < N + M; i++) {
			bw.write(String.valueOf(NNMM[i] + " "));			
		}
		bw.flush();
		bw.close();
	}
}
