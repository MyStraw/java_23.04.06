package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _17091_단어시계 {

	static final String[] num = { "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
			"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen",
			"twenty", "twenty one", "twenty two", "twenty three", "twenty four", "twenty five", "twenty six",
			"twenty seven", "twenty eight", "twenty nine" };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int h = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());	

		System.out.println(time(h, m));
	}

	static String time(int h, int m) {
		if (m == 0) {
			return num[h - 1] + " o' clock";
		} else if (m == 15) {
			return "quarter past " + num[h - 1];
		} else if (m == 30) {
			return "half past " + num[h - 1];
		} else if (m == 45) {
			return "quarter to " + num[h % 12];
		} else if (m < 30) {
			return num[m - 1] + " minute" + (m == 1 ? "" : "s") + " past " + num[h - 1];
		} else {
			return num[59 - m] + " minute" + (60 - m == 1 ? "" : "s") + " to " + num[h % 12];
		}

	}
}
