package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class _28706_럭키세븐 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); 

		StringBuilder sb = new StringBuilder();

		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine()); 
			Set<Integer> dp = new HashSet<>();
			dp.add(1); 

			for (int i = 0; i < N; i++) {
				String[] sick = br.readLine().split(" ");
				int v1 = Integer.parseInt(sick[1]);
				int v2 = Integer.parseInt(sick[3]);

				Set<Integer> next = new HashSet<>();

				for (int k : dp) {					
					if (sick[0].equals("+")) {
						next.add((k + v1) % 7);
					} else if (sick[0].equals("*")) {
						next.add((k * v1) % 7);
					}
					
					if (sick[2].equals("+")) {
						next.add((k + v2) % 7);
					} else if (sick[2].equals("*")) {
						next.add((k * v2) % 7);
					}
				}

				dp = next;
			}

			if (dp.contains(0)) {
				sb.append("LUCKY\n");
			} else {
				sb.append("UNLUCKY\n");
			}
		}

		System.out.print(sb.toString());
	}

}
