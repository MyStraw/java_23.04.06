package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _25239_가희와카오스파풀라투스 {
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

	
		String initialTime = br.readLine();
		st = new StringTokenizer(initialTime, ":");
		int hh = Integer.parseInt(st.nextToken());
		int mm = Integer.parseInt(st.nextToken());

	
		st = new StringTokenizer(br.readLine());
		int[] sectors = new int[6];
		for (int i = 0; i < 6; i++) {
			sectors[i] = Integer.parseInt(st.nextToken());
		}
	
		int L = Integer.parseInt(br.readLine());
		List<Event> events = new ArrayList<>();
		for (int i = 0; i < L; i++) {
			String eventLine = br.readLine();
			events.add(parseEvent(eventLine));
		}
		
		int currentSector = getSector(hh, mm);
		boolean[] sealed = new boolean[6];
	
		for (Event event : events) {
			if (event.type.equals("^")) {
				sealed[currentSector-1] = true;
			} else {				
				int[] newTime = addTime(hh, mm, event);
				hh = newTime[0];
				mm = newTime[1];
				currentSector = getSector(hh, mm);
			}
		}
	
		int healPercentage = 0;
		for (int i = 0; i < 6; i++) {
			if (!sealed[i]) {
				healPercentage += sectors[i];
			}
		}
		if (healPercentage > 100) {
			healPercentage = 100;
		}

	
		System.out.println(healPercentage);
	}


	private static Event parseEvent(String eventLine) {
		StringTokenizer st = new StringTokenizer(eventLine);
		String time = st.nextToken();
		String type = st.nextToken();
		return new Event(time, type);
	}

	private static int[] addTime(int hh, int mm, Event event) {
		int addMinutes = 0;
		int addHours = 0;

		switch (event.type) {
		case "10MIN":
			addMinutes = 10;
			break;
		case "30MIN":
			addMinutes = 30;
			break;
		case "50MIN":
			addMinutes = 50;
			break;
		case "2HOUR":
			addHours = 2;
			break;
		case "4HOUR":
			addHours = 4;
			break;
		case "9HOUR":
			addHours = 9;
			break;
		}

		int newMinutes = mm + addMinutes;
		int newHours = hh + addHours + newMinutes / 60;
		newMinutes %= 60;
		newHours %= 12;

		return new int[] { newHours, newMinutes };
	}


	private static int getSector(int hh, int mm) {
		double angle = (hh % 12) * 30 + mm * 0.5;
		if (angle >= 0 && angle < 60)
			return 1;
		if (angle >= 60 && angle < 120)
			return 2;
		if (angle >= 120 && angle < 180)
			return 3;
		if (angle >= 180 && angle < 240)
			return 4;
		if (angle >= 240 && angle < 300)
			return 5;
		return 6;
	}


	static class Event {
		String time;
		String type;

		public Event(String time, String type) {
			this.time = time;
			this.type = type;
		}
	}

}
