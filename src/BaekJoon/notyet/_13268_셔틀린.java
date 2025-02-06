package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _13268_셔틀린 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int remain = n;
		int d = 0;

		while (remain > 0) {
			d = 0;
			for (int i = 1; i <= 4; i++) {

				for (int j = 0; j < i; j++) {
					remain -= 5;
					if (remain <= 0) {
						d += 5 + remain;
						break;
					}
					d += 5;
				}
				if (remain <= 0)
					break;

				for (int j = 0; j < i; j++) {
					remain -= 5;
					if (remain <= 0) {
						d -= 5 + remain;
						break;
					}
					d -= 5;
				}
				if (remain <= 0)
					break;
			}
			if (remain <= 0)
				break;
		}

		System.out.println(d % 5 == 0 ? d / 5 : d / 5 + 1);
	}

}
