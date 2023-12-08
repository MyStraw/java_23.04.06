package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class _2108_통계학2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int tong[] = new int[N];

		int total = 0;

		for (int i = 0; i < N; i++) {
			tong[i] = Integer.parseInt(br.readLine());
			total += tong[i];
		}

//		Map<Integer, Integer> countTong = new HashMap<>();
//		for (int tongtong : tong) {
//			countTong.put(tongtong, countTong.getOrDefault(tongtong, 0) + 1);
//		}//근데 해쉬맵은 인덱스처럼 순서가 있지가 않다. 해쉬맵 대신 트리맵을 써!

		Map<Integer, Integer> countTong = new TreeMap<>();
		for (int tongtong : tong) {
			countTong.put(tongtong, countTong.getOrDefault(tongtong, 0) + 1);
		}

		int max = -500000;
		for (int i = 0; i < countTong.size(); i++) {		

		}

		int sansul = total / N;
		System.out.printf("%d", sansul);
		System.out.println();
		Arrays.sort(tong);
		System.out.println(tong[N / 2]);
		System.out.println(tong[N - 1] - tong[0]);
	}

}
