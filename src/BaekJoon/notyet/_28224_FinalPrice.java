package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _28224_FinalPrice {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int initialPrice = Integer.parseInt(br.readLine());

		int finalPrice = initialPrice;

		for (int i = 1; i < n; i++) {
			int dailyChange = Integer.parseInt(br.readLine());
			finalPrice += dailyChange;
		}

		System.out.println(finalPrice);
	}

}
