package _백준대회.SciOI_2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class A번_기속사소등4 {
	static int[] roomState, prefixOff, fenwicksumCache, diff;
	static boolean[] turnedOff, visitedInQueue;
	static Set<Integer> A;
	static int N, K;
	static int offCount = 0;

	public static void main(String[] args) throws IOException {
		solve();
	}

	static void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		A = new HashSet<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			A.add(Integer.parseInt(st.nextToken()));
		}

		roomState = new int[N];
		prefixOff = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			roomState[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			prefixOff[i] = prefixOff[i - 1] + (1 - roomState[i - 1]);
		}
		offCount = prefixOff[N];

		turnedOff = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			if (roomState[i - 1] == 0) {
				turnedOff[i] = true;
			}
		}

		diff = new int[N + 2];
		fenwicksumCache = new int[N + 1];
		visitedInQueue = new boolean[N + 1];
		Deque<Integer> queue = new ArrayDeque<>();

		for (int i = 1; i <= N; i++) {
			if (!turnedOff[i]) {
				if (prefixOff[i - 1] == 0 && A.contains(prefixOff[i - 1])) {
					queue.add(i);
					visitedInQueue[i] = true;
				} else if (A.contains(prefixOff[i - 1])) {
					queue.add(i);
					visitedInQueue[i] = true;
				}
			}
		}

		while (!queue.isEmpty()) {
			int cur = queue.poll();
			if (turnedOff[cur])
				continue;
			int val = prefixOff[cur - 1] + getSum(cur);
			if (A.contains(val)) {
				turnedOff[cur] = true;
				offCount++;
				if (cur + 1 <= N) {
					diff[cur + 1]++;
				}
				for (int nxt = cur + 1; nxt <= N; nxt++) {
					if (!turnedOff[nxt] && !visitedInQueue[nxt]) {
						int cval = prefixOff[nxt - 1] + getSum(nxt);
						if (A.contains(cval)) {
							queue.add(nxt);
							visitedInQueue[nxt] = true;
						}
					}
				}
			}
			fenwicksumCache[cur] = (cur == 1 ? 0 : fenwicksumCache[cur - 1]) + diff[cur];
		}
		System.out.println(N - offCount);
	}

	static int getSum(int pos) {
		return fenwicksumCache[pos];
	}
}
