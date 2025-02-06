package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _26126_맛집가이드 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[][] v = new int[n][2];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int a = Integer.parseInt(st.nextToken()) - 1;
			v[a][0] = i + 1;
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int a = Integer.parseInt(st.nextToken()) - 1;
			v[a][1] = i + 1;
		}

		Arrays.sort(v, (a, b) -> Integer.compare(a[0], b[0]));

		int mx = 0;
		int i = 1;
		int lst = 0;
		int count = 0;
		for (int[] pair : v) {
			mx = Math.max(mx, pair[1]);
			if (i == mx && i - lst >= k) {
				count++;
				lst = i;
			}
			i++;
		}

		System.out.println(count);
	}

}
