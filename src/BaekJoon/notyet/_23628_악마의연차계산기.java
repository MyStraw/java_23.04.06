package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _23628_악마의연차계산기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		int startYear = Integer.parseInt(st.nextToken());
		int startMonth = Integer.parseInt(st.nextToken());
		int startDay = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int endYear = Integer.parseInt(st.nextToken());
		int endMonth = Integer.parseInt(st.nextToken());
		int endDay = Integer.parseInt(st.nextToken());
	
		int totalDays = calTotal(startYear, startMonth, startDay, endYear, endMonth, endDay);
	
		int[] count = calLeave(startYear, startMonth, startDay, totalDays);

		bw.write(count[0] + " " + count[1] + "\n");
		bw.write(totalDays + "days\n");

		bw.flush();
		bw.close();
		br.close();
	}

	private static int calTotal(int startYear, int startMonth, int startDay, int endYear, int endMonth,
			int endDay) {
		int startTotalDays = startYear * 360 + (startMonth - 1) * 30 + (startDay - 1);
		int endTotalDays = endYear * 360 + (endMonth - 1) * 30 + (endDay - 1);
		return endTotalDays - startTotalDays;
	}

	private static int[] calLeave(int startYear, int startMonth, int startDay, int totalDays) {
		int totalMonths = totalDays / 30;
		int totalYears = totalMonths / 12;

		int monthlyLeave = Math.min(totalMonths, 36);

		int annualLeave = 0;
		for (int i = 1; i <= totalYears; i++) {
			int a = (i - 1) / 2;
			annualLeave += 15 + a;
		}

		return new int[] { annualLeave, monthlyLeave };
	}

}
