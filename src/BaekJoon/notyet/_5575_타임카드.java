package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _5575_타임카드 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		

		for (int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int chulH = Integer.parseInt(st.nextToken());
			int chulM = Integer.parseInt(st.nextToken());
			int chulS = Integer.parseInt(st.nextToken());
			int toiH = Integer.parseInt(st.nextToken());
			int toiM = Integer.parseInt(st.nextToken());
			int toiS = Integer.parseInt(st.nextToken());

			int start = chulH * 3600 + chulM * 60 + chulS;
			int end = toiH * 3600 + toiM * 60 + toiS;

			int time = end - start;

			int h = time / 3600;
			int m = time % 3600 / 60;
			int s = time % 60;

			System.out.println(h + " " + m + " " + s);
		}

	}

}
