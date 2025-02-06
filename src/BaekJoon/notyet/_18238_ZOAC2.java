package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _18238_ZOAC2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int time = 0;
		char current = 'A';

		for (char c : s.toCharArray()) {
			int clockwise = Math.abs(c - current);
			int counterClockwise = 26 - clockwise;
			time += Math.min(clockwise, counterClockwise);
			current = c;
		}

		System.out.println(time);
	}

}
