package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class _21633_BankTransfer {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());

		double commission = 25 + (k * 0.01);

		if (commission < 100) {
			commission = 100;
		} else if (commission > 2000) {
			commission = 2000;
		}

		DecimalFormat df = new DecimalFormat("0.00");
		System.out.println(df.format(commission));
	}

}
