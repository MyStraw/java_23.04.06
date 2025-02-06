package _백준대회.홍익대학교2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B번_드랍더비트 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		int result = findMaxXOR(N, a, b);
		System.out.println(result);
		
	}

	private static int findMaxXOR(int N, int a, int b) {
		int maxXOR = 0;
		List<Integer> combinations = generateCombinations(N);

		for (int x : combinations) {
			if (Integer.bitCount(x) != a)
				continue;
			for (int y : combinations) {
				if (Integer.bitCount(y) != b)
					continue;
				maxXOR = Math.max(maxXOR, x ^ y);
			}
		}

		return maxXOR;
	}

	private static List<Integer> generateCombinations(int N) {
		List<Integer> combinations = new ArrayList<>();
		for (int i = 0; i < (1 << N); i++) {
			combinations.add(i);
		}
		return combinations;
	}

}
