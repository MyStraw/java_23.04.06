package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class _9375_패션왕신해빈 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			Map<String, Integer> clothes = new HashMap<>();

			for (int i = 0; i < n; i++) {
				String[] input = br.readLine().split(" ");
				String type = input[1];
				clothes.put(type, clothes.getOrDefault(type, 0) + 1);
			}

			long result = 1;
			for (int count : clothes.values()) {
				result *= (count + 1);
			}

			sb.append(result - 1).append("\n");
		}
		System.out.print(sb);		
	}

}
