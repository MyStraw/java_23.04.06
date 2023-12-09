package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _2108_통계학4 {
	// 맵으로 키에 입력값을 넣고, value에 빈도수를 넣자
	// 그럼 이거에서 어떻게 최빈값중 2번째로 작은애를 찾지?

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

		HashMap<Integer, Integer> freq = new HashMap<>();

		for (int num : tong) {
			freq.put(num, freq.getOrDefault(num, 0) + 1); // num이 있으면 그 value 반환, 없으면 0
		}

		List<Integer> modes = new ArrayList<>();
		int maxFreq = Collections.max(freq.values()); // 콜렉션에 max 함수로 freq의 value중 최빈값 찾기

		for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
			if (entry.getValue() == maxFreq) {
				modes.add(entry.getKey());
			}
		}

		// 최빈값 여러개일때 두번재로 작은값 찾기

		Collections.sort(modes);
		int mode = 0;
		if (modes.size() > 1) {
			mode = modes.get(1);
		} else {
			mode = modes.get(0);
		}

		double sansul = (double) total / N;
		bw.write(String.valueOf(Math.round(sansul) + "\n"));
		Arrays.sort(tong);
		bw.write(String.valueOf(tong[N / 2] + "\n"));

		bw.write(String.valueOf(mode) + "\n");

		bw.write(tong[N - 1] - tong[0] + "\n");

		bw.flush();
		bw.close();
	}

}
