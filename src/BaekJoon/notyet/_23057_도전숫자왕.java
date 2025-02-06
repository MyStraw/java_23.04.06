package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _23057_도전숫자왕 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] cards = new int[N];
		int sum = 0;
		for (int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
			sum += cards[i];
		}

		boolean[] possible = new boolean[sum + 1];
		possible[0] = true;

		for (int card : cards) {
			for (int j = sum; j >= card; j--) {
				if (possible[j - card]) {
					possible[j] = true;
				}
			}
		}

		int count = 0;
		for (int i = 1; i <= sum; i++) {
			if (!possible[i]) {
				count++;
			}
		}

		System.out.println(count);
	}

}
