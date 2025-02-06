package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class _23057_도전숫자왕2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] cards = new int[N];
		int totalSum = 0;
		for (int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
			totalSum += cards[i];
		}

		Set<Integer> sums = new HashSet<>();
		sums.add(0);

		for (int card : cards) {
			Set<Integer> newSums = new HashSet<>(sums);
			for (int sum : sums) {
				newSums.add(sum + card);
			}
			sums = newSums;
		}

		int count = totalSum - sums.size() + 1;

		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
		
	}
}