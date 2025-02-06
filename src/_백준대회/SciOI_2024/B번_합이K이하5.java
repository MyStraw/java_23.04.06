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

public class B번_합이K이하5 {
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

		List<List<Long>> groups = new ArrayList<>();
		for (List<Long> group : groupByA.values()) {
			Collections.sort(group);
			groups.add(group);
		}

		long maxSum = Long.MIN_VALUE;
		boolean found = false;

		for (int i = 0; i < groups.size(); i++) {
			for (int j = i + 1; j < groups.size(); j++) {
				List<Long> group1 = groups.get(i);
				List<Long> group2 = groups.get(j);

				int p1 = 0, p2 = group2.size() - 1;

				while (p1 < group1.size() && p2 >= 0) {
					long sum = group1.get(p1) + group2.get(p2);

					if (sum <= K) {
						maxSum = Math.max(maxSum, sum);
						found = true;
						p1++;
					} else {
						p2--;
					}
				}
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
