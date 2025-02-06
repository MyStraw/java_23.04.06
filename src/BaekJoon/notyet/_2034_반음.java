package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _2034_반음 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		char[] piano = { 'C', 'X', 'D', 'X', 'E', 'F', 'X', 'G', 'X', 'A', 'X', 'B' };

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine()) % 12;
		}

		for (char start = 'A'; start <= 'G'; start++) {
			int idx = -1;
			char end = ' ';
			for (int i = 0; i < 12; i++) {
				if (piano[i] == start) {
					idx = i;
					break;
				}
			}

			boolean valid = true;
			for (int i = 0; i < n; i++) {
				idx = (idx + arr[i]) % 12;
				if (idx < 0)
					idx += 12;
				if (piano[idx] == 'X') {
					valid = false;
					break;
				}
				end = piano[idx];
			}

			if (valid) {
				System.out.println(start + " " + end);
			}
		}
	}

}
