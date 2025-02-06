package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _25044_에어컨 {

	static String formatTime(int minutes) {
		int hour = minutes / 60;
		int minute = minutes % 60;
		return String.format("%02d:%02d", hour, minute);
	}

	static int[] calculateNextTime(int time, int add) {
		int newTime = (time + add) % 1440;
		int dayIncrement = (time + add) / 1440;
		return new int[] { newTime, dayIncrement };
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int currentTime = 900;
		int currentDay = 0;
		int[] intervals = { 180, 180, 1080 + K };
		int index = 0;
		List<String> results = new ArrayList<>();

		while (currentDay <= N) {
			if (currentDay == N) {
				results.add(formatTime(currentTime));
			}
			int[] next = calculateNextTime(currentTime, intervals[index]);
			currentTime = next[0];
			currentDay += next[1];
			index = (index + 1) % 3;
		}

		System.out.println(results.size());
		for (String time : results) {
			System.out.println(time);
		}
	}

}
