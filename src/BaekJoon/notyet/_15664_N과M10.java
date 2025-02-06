package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _15664_N과M10 {
	static boolean[] check = new boolean[8];
	static int n, m;
	static int[] num = new int[8], result = new int[8];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(num, 0, n);

		getResult(0, 0);
	}

	static void getResult(int count, int start) {
		if (count == m) {
			for (int i = 0; i < m; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			return;
		}

		int preNum = -1;

		for (int i = start; i < n; i++) {
			if (!check[i] && preNum != num[i]) {
				check[i] = true;
				result[count] = num[i];
				preNum = num[i];

				getResult(count + 1, i);
				check[i] = false;
			}
		}
	}

}
