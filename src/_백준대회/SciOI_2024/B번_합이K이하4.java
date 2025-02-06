package _백준대회.SciOI_2024;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class B번_합이K이하4 {
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

		if (groupByA.size() < 2) {
			bw.write("NO\n");
			bw.flush();
			bw.close();
			return;
		}

		List<Pair> allPairs = new ArrayList<>();
		for (Map.Entry<Long, List<Long>> entry : groupByA.entrySet()) {
			long a = entry.getKey();
			List<Long> bValues = entry.getValue();
			Collections.sort(bValues);
			for (long b : bValues) {
				allPairs.add(new Pair(a, b));
			}
		}

		Collections.sort(allPairs, Comparator.comparingLong(p -> p.b));

		int left = 0, right = allPairs.size() - 1;
		long maxSum = Long.MIN_VALUE;
		boolean found = false;

		while (left < right) {
			Pair leftPair = allPairs.get(left);
			Pair rightPair = allPairs.get(right);

			if (leftPair.a == rightPair.a) {
				if (leftPair.b < rightPair.b) {
					left++;
				} else {
					right--;
				}
				continue;
			}

			long sum = leftPair.b + rightPair.b;

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
