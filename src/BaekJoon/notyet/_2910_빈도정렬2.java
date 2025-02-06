package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class _2910_빈도정렬2 {
	static class Element {
		int value;
		int frequency;
		int firstIndex;

		Element(int value, int frequency, int firstIndex) {
			this.value = value;
			this.frequency = frequency;
			this.firstIndex = firstIndex;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		int[] sequence = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			sequence[i] = Integer.parseInt(st.nextToken());
		}

		Map<Integer, Element> map = new HashMap<>();

		for (int i = 0; i < N; i++) {
			int num = sequence[i];
			if (map.containsKey(num)) {
				map.get(num).frequency++;
			} else {
				map.put(num, new Element(num, 1, i));
			}
		}

		List<Element> list = new ArrayList<>(map.values());

		list.sort((a, b) -> {
			if (b.frequency != a.frequency) {
				return Integer.compare(b.frequency, a.frequency);
			} else {
				return Integer.compare(a.firstIndex, b.firstIndex);
			}
		});

		StringBuilder sb = new StringBuilder();
		for (Element e : list) {
			for (int i = 0; i < e.frequency; i++) {
				sb.append(e.value).append(" ");
			}
		}

		System.out.println(sb.toString());
	}

}
