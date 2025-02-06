package _백준대회.SciOI_2024;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class B번_합이K이하7 {
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

		List<Pair> pairs = new ArrayList<>();
		Map<Long, List<Long>> groupByA = new HashMap<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());

			pairs.add(new Pair(a, b));
			groupByA.putIfAbsent(a, new ArrayList<>());
			groupByA.get(a).add(b);
		}

		if (groupByA.size() < 2) {
			bw.write("NO\n");
			bw.flush();
			bw.close();
			return;
		}

		pairs.sort(Comparator.comparingLong(p -> p.b));

		int left = 0, right = pairs.size() - 1;
		long maxSum = Long.MIN_VALUE;
		boolean found = false;

		while (left < right) {
			Pair leftPair = pairs.get(left);
			Pair rightPair = pairs.get(right);

			long sum = leftPair.b + rightPair.b;

			if (sum > K) { // 최대합 초과시 줄이기
				right--;
			} else { // 조건 충족 시
				if (leftPair.a != rightPair.a) { // 서로 다른 a 값 검증
					maxSum = Math.max(maxSum, sum);
					found = true;

					if (sum == K) { // K와 같으면 바로 출력
						bw.write(sum + "\n");
						bw.flush();
						bw.close();
						return;
					}
				}
				left++; // 다음 조합 탐색
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
