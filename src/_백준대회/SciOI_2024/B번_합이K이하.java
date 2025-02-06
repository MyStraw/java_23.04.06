package _백준대회.SciOI_2024;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B번_합이K이하 { //인덱스 문제가 아니라 조건문제다. 다시생각!
	
	static class Pair {
		long a, b;
		int idx;

		Pair(long a, long b, int idx) {
			this.a = a;
			this.b = b;
			this.idx = idx;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long K = Long.parseLong(st.nextToken());

		Pair[] pairs = new Pair[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			pairs[i] = new Pair(a, b, i);
		}

		Arrays.sort(pairs, (p1, p2) -> {
			if (p1.b == p2.b) {
				return Long.compare(p1.a, p2.a);
			}
			return Long.compare(p1.b, p2.b);
		});

		int left = 0, right = N - 1;
		long maxSum = Long.MIN_VALUE;
		boolean found = false;

		while (left < right) {
			long sum = pairs[left].b + pairs[right].b;

			if (sum <= K) {
				maxSum = Math.max(maxSum, sum);
				found = true;
				left++;
			} else {
				right--;
			}
		}

		if (found) {
			bw.write(maxSum + "\n");
		} else {
			bw.write("NO\n");
		}

		bw.flush();
		bw.close();
	}

}
