package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _27287_OneandTwo {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

			int total = 0;
			for (int i = 0; i < n; i++) {
				if (a[i] == 2)
					total++;
			}

			int left = 0;
			int result = -1;

			for (int k = 1; k < n; k++) {
				if (a[k - 1] == 2)
					left++;
				int right = total - left;

				if (left == right) {
					result = k;
					break;
				}
			}

			System.out.println(result);
		}
	}

}
