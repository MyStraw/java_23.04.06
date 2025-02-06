package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class _2910_빈도정렬 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[] pass = new int[N];

		Map<Integer, Integer> map = new HashMap<>();
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			int re = Integer.parseInt(st.nextToken());
			map.put(re, map.getOrDefault(re, 0) + 1);
		}

		List<Map.Entry<Integer, Integer>> mapList = new ArrayList<>(map.entrySet());

//		Collections.sort(mapList, new Comparator<Map.Entry<Integer, Integer>>() {
//			@Override
//			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
//				if (o2.getValue() - o1.getValue() == 0) {
//					return o1.getKey() - o2.getKey();
//				}
//				return o2.getValue() - o1.getValue();		
//			}
//		});

		Collections.sort(mapList, (o1, o2) -> {
			if (o2.getValue() - o1.getValue() == 0) {
				return o1.getKey() - o2.getKey();
			}
			return o2.getValue() - o1.getValue();

		});

		for (Map.Entry<Integer, Integer> entry : mapList) {
			System.out.println(entry.getKey());
		}

	}

}
