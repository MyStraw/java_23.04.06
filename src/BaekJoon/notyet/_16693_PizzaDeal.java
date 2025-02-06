package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _16693_PizzaDeal {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		double A1 = Integer.parseInt(st.nextToken());
		double P1 = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		double R1 = Integer.parseInt(st.nextToken());
		double P2 = Integer.parseInt(st.nextToken());

		double x = A1 / P1, y = Math.PI * R1 * R1 / P2;

		if (x > y) {
			System.out.println("Slice of pizza");
		} else {
			System.out.println("Whole pizza");
		}

	}

}
