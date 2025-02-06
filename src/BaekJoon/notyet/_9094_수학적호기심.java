package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9094_수학적호기심 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			String[] input = br.readLine().split(" ");
			int n = Integer.parseInt(input[0]);
			int m = Integer.parseInt(input[1]);

			int count = 0;		
			for (int a = 1; a < n; a++) {
				for (int b = a + 1; b < n; b++) {				
					if ((1L * a * a + 1L * b * b + m) % (1L * a * b) == 0) {
						count++;
					}
				}
			}

			System.out.println(count);
		}	
	}
}
