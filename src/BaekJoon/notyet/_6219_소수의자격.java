package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _6219_소수의자격 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		boolean[] john = new boolean[B + 1];
		john[0] = john[1] = true;
		
		for (int i = 2; i * i <= B; i++) {
			if (!john[i]) {
				for (int j = i * i; j <= B; j += i) {
					john[j] = true;
				}
			}
		}

		int count = 0;
		for (int i = A; i <= B; i++) {
			if (!john[i] && tenJari(i, D)) {
				count++;
			}
		}

		System.out.println(count);
	}
	
	private static boolean tenJari(int number, int digit) {
		while (number > 0) {
			if (number % 10 == digit) {
				return true;
			}
			number /= 10;
		}
		return false;
	}

}
