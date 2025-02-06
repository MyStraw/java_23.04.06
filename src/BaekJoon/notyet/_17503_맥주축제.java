package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _17503_맥주축제 {
	static int N, M, K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		List<Beer> beers = new ArrayList<>();
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int prefer = Integer.parseInt(st.nextToken());
			int dosu = Integer.parseInt(st.nextToken());
			beers.add(new Beer(prefer, dosu));
		}

		Collections.sort(beers);

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int totalPrefer = 0;
		int minDosu = -1;

		for (Beer beer : beers) {
			pq.add(beer.prefer);
			totalPrefer += beer.prefer;

			if (pq.size() > N) {
				totalPrefer -= pq.poll();
			}

			if (pq.size() == N && totalPrefer >= M) {
				minDosu = beer.dosu;
				break;
			}
		}

		System.out.print(minDosu);
	}

	static class Beer implements Comparable<Beer> {
		int prefer;
		int dosu;

		Beer(int prefer, int dosu) {
			this.prefer = prefer;
			this.dosu = dosu;
		}

		@Override
		public int compareTo(Beer other) {
			if (this.dosu == other.dosu) {
				return Integer.compare(other.prefer, this.prefer);
			}
			return Integer.compare(this.dosu, other.dosu);
		}
	}
}
