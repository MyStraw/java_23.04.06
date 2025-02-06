package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;

public class _6487_두직선의교차여부 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int testCases = Integer.parseInt(br.readLine());
		DecimalFormat df = new DecimalFormat("0.00");

		for (int i = 0; i < testCases; i++) {
			String[] input = br.readLine().split(" ");
			double x1 = Double.parseDouble(input[0]);
			double y1 = Double.parseDouble(input[1]);
			double x2 = Double.parseDouble(input[2]);
			double y2 = Double.parseDouble(input[3]);
			double x3 = Double.parseDouble(input[4]);
			double y3 = Double.parseDouble(input[5]);
			double x4 = Double.parseDouble(input[6]);
			double y4 = Double.parseDouble(input[7]);

			double manna = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);

			if (manna == 0) {				
				if ((x1 - x3) * (y2 - y1) == (y1 - y3) * (x2 - x1)) {
					bw.write("LINE\n");
				} else {
					bw.write("NONE\n");
				}
			} else {				
				double x = ((x1 * y2 - y1 * x2) * (x3 - x4) - (x1 - x2) * (x3 * y4 - y3 * x4)) / manna;
				double y = ((x1 * y2 - y1 * x2) * (y3 - y4) - (y1 - y2) * (x3 * y4 - y3 * x4)) / manna;
				bw.write("POINT " + df.format(x) + " " + df.format(y) + "\n");
			}
		}

		br.close();
		bw.flush();
		bw.close();
	}

}
