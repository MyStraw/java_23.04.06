package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _15781_헬멧과조끼 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		long helmet[] = new long[N];
		long vest[] = new long[M];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			helmet[i] = Long.parseLong(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			vest[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(helmet);
		Arrays.sort(vest);

		System.out.println(helmet[N - 1] + vest[M - 1]);

	}

}
