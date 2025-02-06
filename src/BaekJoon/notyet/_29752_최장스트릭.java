package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _29752_최장스트릭 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int streak[] = new int[N];

		int max = 0;
		int count = 0;

		for (int i = 0; i < N; i++) {
			streak[i] = Integer.parseInt(st.nextToken());
			if (streak[i] != 0) {
				count++;
			} else {
				count = 0;
			}
			if (max < count) {
				max = count;
			}
		}
		System.out.println(max);

	}

}
