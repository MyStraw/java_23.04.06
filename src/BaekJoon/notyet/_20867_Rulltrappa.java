package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _20867_Rulltrappa {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] firstLine = br.readLine().split(" ");
		int M = Integer.parseInt(firstLine[0]);
		int S = Integer.parseInt(firstLine[1]);
		int G = Integer.parseInt(firstLine[2]);

		String[] secondLine = br.readLine().split(" ");
		double A = Double.parseDouble(secondLine[0]);
		double B = Double.parseDouble(secondLine[1]);

		String[] thirdLine = br.readLine().split(" ");
		int L = Integer.parseInt(thirdLine[0]);
		int R = Integer.parseInt(thirdLine[1]);

		double rightQ = (R / B) + (double) M / S;

		double leftQ = (L / A) + (double) M / G;

		if (rightQ < leftQ) {
			System.out.println("latmask");
		} else {
			System.out.println("friskus");
		}
	}

}
