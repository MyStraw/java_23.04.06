package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _3231_카드놀이 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int card[] = new int[N];

		for (int i = 0; i < N; i++) {
			card[i] = Integer.parseInt(br.readLine());
		}

		int clap = 0;
		int currentNum = 1;
		int i = 0;

		while (currentNum <= N) {
			while (i < N && card[i] != currentNum) {
				i++;
			}
			if (i == N) {
				clap++;
				i = 0;
			} else {
				currentNum++;
				i++;
			}

		}
		System.out.println(clap);
	}

}
