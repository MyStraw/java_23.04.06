package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class _18870_좌표압축 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		Map<Integer, Integer> vertical = new HashMap<>();
		List<Integer> verti = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			vertical.put(num, vertical.getOrDefault(num, 0) + 1);
			verti.add(num);
		}

		Collections.sort(verti);
		LinkedHashSet<Integer> set = new LinkedHashSet<>(verti);

		System.out.println(vertical);
		System.out.println(verti);
		System.out.println(set);
	}
}
