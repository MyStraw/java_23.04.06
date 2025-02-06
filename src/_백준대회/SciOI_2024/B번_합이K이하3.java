package _백준대회.SciOI_2024;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class B번_합이K이하3 {
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

		Map<Long, List<Long>> groupByA = new HashMap<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());

			groupByA.putIfAbsent(a, new ArrayList<>());
			groupByA.get(a).add(b);
		}

		List<Long> bValues = new ArrayList<>();

		for (List<Long> values : groupByA.values()) {
			bValues.addAll(values);
		}

		Collections.sort(bValues);

		int left = 0, right = bValues.size() - 1;
		long maxSum = Long.MIN_VALUE;
		boolean found = false;

		while (left < right) {
			long sum = bValues.get(left) + bValues.get(right);

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
