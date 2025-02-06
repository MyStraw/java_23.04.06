package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class _16196_중국신분증번호 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String id = br.readLine().trim();

		int n = Integer.parseInt(br.readLine().trim());
		Set<String> validRegionCodes = new HashSet<>();
		for (int i = 0; i < n; i++) {
			validRegionCodes.add(br.readLine().trim());
		}
	
		if (id.length() != 18) {
			System.out.println("I");
			return;
		}
	
		String regionCode = id.substring(0, 6);
		if (!validRegionCodes.contains(regionCode)) {
			System.out.println("I");
			return;
		}
		
		String birthCode = id.substring(6, 14);
		int year = Integer.parseInt(birthCode.substring(0, 4));
		int month = Integer.parseInt(birthCode.substring(4, 6));
		int day = Integer.parseInt(birthCode.substring(6, 8));

		if (year < 1900 || year > 2011 || month < 1 || month > 12 || day < 1 || day > 31
				|| !isValidDate(year, month, day)) {
			System.out.println("I");
			return;
		}
	
		String sequenceCode = id.substring(14, 17);
		int seq = Integer.parseInt(sequenceCode);
		if (seq <= 0 || seq > 999) {
			System.out.println("I");
			return;
		}
		
		int[] weights = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };
		int sum = 0;
		for (int i = 0; i < 17; i++) {
			sum += (id.charAt(i) - '0') * weights[i];
		}
		int remainder = sum % 11;
		char expectedChecksum = (remainder == 2) ? 'X' : (char) ((12 - remainder) % 11 + '0');
		if (id.charAt(17) != expectedChecksum) {
			System.out.println("I");
			return;
		}
		
		System.out.println(seq % 2 != 0 ? "M" : "F");
	}

	private static boolean isValidDate(int year, int month, int day) {
		if (month == 2) {
			if (isLeapYear(year)) {
				return day <= 29;
			} else {
				return day <= 28;
			}
		} else if (month == 4 || month == 6 || month == 9 || month == 11) {
			return day <= 30;
		} else {
			return day <= 31;
		}
	}

	private static boolean isLeapYear(int year) {
		return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
	}

}
