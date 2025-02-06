package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11561_징검다리 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		while (T-- > 0) {
			long N = Long.parseLong(br.readLine());
			long left = 1, right = (long) Math.sqrt(2 * N) + 1, ans = 0;

			while (left <= right) {
				long mid = (left + right) / 2;
				if (mid * (mid + 1) / 2 <= N) {
					ans = mid;
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
			sb.append(ans).append("\n");
		}
		System.out.print(sb);
	}

}
