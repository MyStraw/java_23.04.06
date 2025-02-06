package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2597_줄자접기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		double rlen = Double.parseDouble(br.readLine());
		double llen = 0;

		double[][] pointList = new double[3][2];
		for (int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			pointList[i][0] = Double.parseDouble(st.nextToken());
			pointList[i][1] = Double.parseDouble(st.nextToken());
		}

		for (int i = 0; i < 3; i++) {
			double a = pointList[i][0];
			double b = pointList[i][1];
			if (a == b)
				continue;

			double mid = (a + b) / 2;
			double tempLlen = mid * 2 - rlen;
			rlen = mid;
			llen = Math.min(llen, tempLlen);

			for (int j = i + 1; j < 3; j++) {
				for (int k = 0; k < 2; k++) {
					if (pointList[j][k] > mid) {
						pointList[j][k] = mid * 2 - pointList[j][k];
					}
				}
			}
		}

		System.out.printf("%.1f\n", rlen - llen);
	}
}
