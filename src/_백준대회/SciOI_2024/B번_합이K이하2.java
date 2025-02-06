package _백준대회.SciOI_2024;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B번_합이K이하2 { // 인덱스 문제가 아니라 조건문제다. 다시생각!
	static class Pair {
		long a, b;

		Pair(long a, long b) {
			this.a = a;
			this.b = b;
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
			pairs[i] = new Pair(a, b);
		}

		Arrays.sort(pairs, (p1, p2) -> Long.compare(p2.b, p1.b));

		long maxSum = Long.MIN_VALUE;
		boolean found = false;

		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				long sum = pairs[i].b + pairs[j].b;
				if (sum <= K) { // 갱신
					maxSum = Math.max(maxSum, sum);
					found = true;
				} else {
					break;
				}
			}
		}

		if (found) {
			bw.write(maxSum + "\n");
		} else {
			bw.write("NO\n");
		}

		bw.flush();
		br.close();
		bw.close();
	}

}
