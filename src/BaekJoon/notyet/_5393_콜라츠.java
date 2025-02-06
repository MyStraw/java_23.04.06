package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _5393_콜라츠 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCase = Integer.parseInt(br.readLine());

		for (int i = 0; i < testCase; i++) {
			int x = Integer.parseInt(br.readLine());
			int ans = 0;
		
			if (x % 2 == 0)
				ans += x / 2;
			else
				ans += x / 2 + 1;
		
			if (x % 6 == 0 || x % 6 == 4)
				ans += x / 3;
			else
				ans += x / 3 + 1;

			System.out.println(ans);
		}

	}
}
