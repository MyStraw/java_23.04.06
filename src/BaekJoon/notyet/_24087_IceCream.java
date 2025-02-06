package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _24087_IceCream {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int S = Integer.parseInt(br.readLine());
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());

		int basePrice = 250;
		int additionalPrice = 100;

		if (A >= S) {
			System.out.println(basePrice);
		} else {
			int additionalIceCreams = (S - A + B - 1) / B;
			int totalPrice = basePrice + additionalIceCreams * additionalPrice;
			System.out.println(totalPrice);
		}
	}

}
