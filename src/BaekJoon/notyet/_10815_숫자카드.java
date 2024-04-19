package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _10815_숫자카드 { //해쉬, 맵 써도 될듯
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] sangGeun = new int[N];

		for (int i = 0; i < N; i++) {
			sangGeun[i] = Integer.parseInt(st.nextToken());
		}

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] card = new int[M];

		for (int i = 0; i < M; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(sangGeun);

		for (int num : card) {
			int start = 0;
			int end = sangGeun.length - 1;
			System.out.print(binary(sangGeun, num, start, end) + " ");

		}
	}

	private static int binary(int[] sangGeun, int num, int start, int end) {
		while (start <= end) {
			int mid = (start + end) / 2;
			if (sangGeun[mid] > num) {
				end = mid - 1;
			} else if (sangGeun[mid] < num) {
				start = mid + 1;
			} else if (sangGeun[mid] == num) {
				return 1;
			}
		}
		return 0;
	}
}
