package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _17392_우울한방학 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] promise = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			promise[i] = Integer.parseInt(st.nextToken());
		}

		int sum;
		if (sum(promise) >= M) {
			sum = 0;
		} else {
			int m = M;
			int blue = 0;
			int idx = 0;
			while (m > 0) {
				blue -= 1;
				if (blue <= -1) {
					if (idx < N) {
						blue = promise[idx];
						idx++;
					} else {
						break;
					}
				}
				m--;
			}

			int count = m;
			sum = 0;
			idx = 1;
			int jegop = 1;
			while (idx <= count) {
				for (int i = 0; i <= N; i++) {
					if (idx > count) {
						break;
					}
					sum += jegop * jegop;
					idx++;
				}
				jegop++;
			}
		}

		System.out.println(sum);
	}

	private static int sum(int[] arr) {
		int sum = 0;
		for (int num : arr) {
			sum += num;
		}
		return sum;
	}

}
