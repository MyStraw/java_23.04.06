package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class _32201_눈사람 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		Map<Integer, Integer> initialRank = new HashMap<>();
		for (int i = 0; i < N; i++) {
			int player = Integer.parseInt(st.nextToken());
			initialRank.put(player, i); // 선수 번호 -> 초기 등수 저장
		}

		st = new StringTokenizer(br.readLine());
		int[] finalRank = new int[N];
		int maxIncrease = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			int player = Integer.parseInt(st.nextToken());
			finalRank[i] = player;

			// 등수 변화
			int initialPosition = initialRank.get(player);
			int increase = initialPosition - i;
			maxIncrease = Math.max(maxIncrease, increase);
		}

		StringBuilder result = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int player = finalRank[i];
			int initialPosition = initialRank.get(player);
			if (initialPosition - i == maxIncrease) {
				result.append(player).append(" ");
			}
		}

		System.out.println(result.toString());
	}

}
