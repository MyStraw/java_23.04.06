package _백준대회.홍익대학교2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class C번_유물발굴 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(br.readLine());

		Map<Integer, int[]> artifacts = new HashMap<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int ai = Integer.parseInt(st.nextToken());
			int vi = Integer.parseInt(st.nextToken());
			int hi = Integer.parseInt(st.nextToken());

			if (!artifacts.containsKey(ai)) {
				artifacts.put(ai, new int[] { vi, vi, hi, hi });
			} else {
				int[] coords = artifacts.get(ai);
				coords[0] = Math.min(coords[0], vi);
				coords[1] = Math.max(coords[1], vi);
				coords[2] = Math.min(coords[2], hi);
				coords[3] = Math.max(coords[3], hi);
			}
		}

		long maxSize = 0;
		int result = Integer.MAX_VALUE;

		for (Map.Entry<Integer, int[]> entry : artifacts.entrySet()) {
			int ai = entry.getKey();
			int[] coords = entry.getValue();
			long size = (long)(coords[1] - coords[0] + 1) * (coords[3] - coords[2] + 1);

			if (size > maxSize) {
				maxSize = size;
				result = ai;
			} else if (size == maxSize && ai < result) {
				result = ai;
			}
		}

		System.out.println(result + " " + maxSize);
	}

}
