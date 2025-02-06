package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11296_가격 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			String[] line = br.readLine().split(" ");

			double price = Double.parseDouble(line[0]);
			String dots = line[1];
			String coupon = line[2];
			String payment = line[3];

			double discount = 0;

			switch (dots) {
			case "R":
				discount = 0.45;
				break;
			case "G":
				discount = 0.3;
				break;
			case "B":
				discount = 0.2;
				break;
			case "Y":
				discount = 0.15;
				break;
			case "O":
				discount = 0.1;
				break;
			case "W":
				discount = 0.05;
				break;
			}
			price = price * (1 - discount);

			price -= coupon.equals("C") ? price * 0.05 : 0;
			price = Math.round(price * 100) / 100.0;

			if (payment.equals("C")) {
				int secondDecimal = (int) (price * 100 % 10);

				if (secondDecimal >= 6) {
					price = Math.round(price);
				} else {
					price = (price * 100 - secondDecimal) / 100.0;
				}
			}

			String result = String.format("%.2f", price);
			System.out.println("$" + result);

		}

	}

}
