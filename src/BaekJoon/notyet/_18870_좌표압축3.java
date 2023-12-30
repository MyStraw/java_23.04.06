package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class _18870_좌표압축3 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] original = new int[N];
		int[] sorted = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			original[i] = sorted[i] = Integer.parseInt(st.nextToken());
		}
	
		Arrays.sort(sorted);
		Map<Integer, Integer> indexMap = new HashMap<>();
		int idx = 0;
		for (int i = 0; i < N; i++) {
			if (!indexMap.containsKey(sorted[i])) {
				indexMap.put(sorted[i], idx++);
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(indexMap.get(original[i])).append(" ");
		}

		System.out.println(sb);
	}
}
