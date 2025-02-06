package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _17359_전구길만걷자 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		String[] vs = new String[n];
		int base = 0;

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			vs[i] = s;
			for (int j = 0; j < s.length() - 1; j++) {
				if (s.charAt(j) != s.charAt(j + 1)) {
					base += 1;
				}
			}
		}

		int[] idx = new int[n];
		for (int i = 0; i < n; i++) {
			idx[i] = i;
		}

		int ans = -1;

		do {
			int cnt = 0;
			for (int i = 0; i < n - 1; i++) {
				if (vs[idx[i]].charAt(vs[idx[i]].length() - 1) != vs[idx[i + 1]].charAt(0)) {
					cnt += 1;
				}
			}
			if (ans == -1 || ans > cnt) {
				ans = cnt;
			}
		} while (next(idx));

		System.out.println(base + ans);
	}

	private static boolean next(int[] array) {
		int i = array.length - 1;
		while (i > 0 && array[i - 1] >= array[i]) {
			i--;
		}
		if (i <= 0) {
			return false;
		}

		int j = array.length - 1;
		while (array[j] <= array[i - 1]) {
			j--;
		}

		int temp = array[i - 1];
		array[i - 1] = array[j];
		array[j] = temp;

		j = array.length - 1;
		while (i < j) {
			temp = array[i];
			array[i] = array[j];
			array[j] = temp;
			i++;
			j--;
		}

		return true;
	}

}
