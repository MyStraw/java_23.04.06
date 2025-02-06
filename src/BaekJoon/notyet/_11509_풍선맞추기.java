package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _11509_풍선맞추기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] ball = new int[N];

		for (int i = 0; i < N; i++) {
			ball[i] = Integer.parseInt(st.nextToken());
		}

		HashMap<Integer, Integer> map = new HashMap<>();
		int count = 0;

		for (int arrow : ball) {
			if (map.getOrDefault(arrow, 0) > 0) { 
				map.put(arrow, map.get(arrow) - 1);
			} else {
				count++; //
			}
			map.put(arrow - 1, map.getOrDefault(arrow - 1, 0) + 1);
		}
		System.out.println(count);
	}
}
