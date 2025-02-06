package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _24061_알고리즘수업_병합정렬2 {
	static int[] a, tmp;
	static int k, cnt;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		a = new int[n];
		tmp = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		cnt = 0;
		mergeSort(0, n - 1);

		if (cnt < k) {
			System.out.println(-1);
		} else {
			System.out.println(sb.toString().trim());
		}
	}

	static void mergeSort(int p, int r) {
		if (p < r) {
			int q = (p + r) / 2;
			mergeSort(p, q);
			mergeSort(q + 1, r);
			merge(p, q, r);
		}
	}

	static void merge(int p, int q, int r) {
		int i = p, j = q + 1, t = 0;

		while (i <= q && j <= r) {
			if (a[i] <= a[j]) {
				tmp[t++] = a[i++];
			} else {
				tmp[t++] = a[j++];
			}
		}

		while (i <= q)
			tmp[t++] = a[i++];
		while (j <= r)
			tmp[t++] = a[j++];

		t = 0;
		for (i = p; i <= r; i++) {
			a[i] = tmp[t++];
			cnt++;
			if (cnt == k) {
				for (int x = 0; x < a.length; x++) {
					sb.append(a[x]).append(" ");
				}
				return;
			}
		}
	}

}
