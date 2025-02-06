package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _16363_13일의금요일 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        int dayOfWeek = 2;

        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        for (int year = 2019; year <= N; year++) {
            for (int month = 0; month < 12; month++) {
                if ((dayOfWeek + 12) % 7 == 5) {
                    count++;
                }
                dayOfWeek += daysInMonth[month];
                if (month == 1 && isLeapYear(year)) {
                    dayOfWeek++;
                }
            }
        }

        System.out.println(count);
    }

    private static boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        }
        if (year % 100 == 0) {
            return false;
        }
        return year % 4 == 0;
    }

}
