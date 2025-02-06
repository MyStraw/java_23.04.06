package BaekJoon.notyet;

import java.util.Scanner;

public class _15080_everySecond {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String startTime = sc.nextLine().trim();
		String endTime = sc.nextLine().trim();
		
		int startSec = change(startTime);
		int endSec = change(endTime);

		int elapsedTime = caculate(startSec, endSec);
	
		System.out.println(elapsedTime);
	}

	private static int change(String time) {
		String[] parts = time.split(" : ");
		int hour = Integer.parseInt(parts[0]);
		int min = Integer.parseInt(parts[1]);
		int sec = Integer.parseInt(parts[2]);
		return hour * 3600 + min * 60 + sec;
	}

	private static int caculate(int startSec, int endSec) {		
		if (endSec < startSec) {
			endSec += 24 * 3600;
		}
		return endSec - startSec;
	}

}
