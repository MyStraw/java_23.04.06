package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _18110_solved {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] opinion = new int[n];

		for (int i = 0; i < n; i++) {
			opinion[i] = Integer.parseInt(br.readLine());
		}

		System.out.println(cal(opinion));
	}

	private static int cal(int[] opinion) {
		if (opinion.length == 0) {
			return 0;
		}

		Arrays.sort(opinion);

		int jul = (int) Math.round(opinion.length * 0.15);
		int sum = 0;
		for (int i = jul; i < opinion.length - jul; i++) {
			sum += opinion[i];
		}

		return (int) Math.round((double) sum / (opinion.length - 2 * jul));
	}

}
