package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _8989_시계 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder result = new StringBuilder();

		for (int t = 0; t < T; t++) {
			String[] times = br.readLine().split(" ");
			List<TimeAngle> timeAngles = new ArrayList<>();

			for (String time : times) {
				String[] splitTime = time.split(":");
				int hours = Integer.parseInt(splitTime[0]) % 12;
				int minutes = Integer.parseInt(splitTime[1]);

				double hourAngle = (hours * 30) + (minutes * 0.5);
				double minuteAngle = minutes * 6;
				double angle = Math.abs(hourAngle - minuteAngle);
				angle = Math.min(angle, 360 - angle);

				timeAngles.add(new TimeAngle(time, angle));
			}

			Collections.sort(timeAngles);

			result.append(timeAngles.get(2).time).append("\n");
		}

		System.out.print(result.toString());
	}
}

class TimeAngle implements Comparable<TimeAngle> {
	String time;
	double angle;

	TimeAngle(String time, double angle) {
		this.time = time;
		this.angle = angle;
	}

	@Override
	public int compareTo(TimeAngle other) {
		if (this.angle != other.angle) {
			return Double.compare(this.angle, other.angle);
		}
		return this.time.compareTo(other.time);
	}

}
