package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _25206_너의평점은 {
	private static double totals = 0;
	private final static int N = 20;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		double result = 0;
		double hak = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			double credit = Double.parseDouble(st.nextToken());

			String grade = st.nextToken();

			if (!grade.equals("P")) {
				result += total(credit, grade);
				hak += credit;
			}
		}
		totals = result / hak;
		bw.write(String.format("%.6f", totals));		
		bw.flush();
		bw.close();

	}

	static double total(double credit, String grade) {

		switch (grade) {

		case "A+":
			return credit * 4.5;

		case "A0":
			return credit * 4.0;

		case "B+":
			return credit * 3.5;

		case "B0":
			return credit * 3.0;

		case "C+":
			return credit * 2.5;

		case "C0":
			return credit * 2.0;

		case "D+":
			return credit * 1.5;

		case "D0":
			return credit * 1.0;

		case "F":
			return credit * 0.0;
		default:
			return 0;
		}
	}
}
