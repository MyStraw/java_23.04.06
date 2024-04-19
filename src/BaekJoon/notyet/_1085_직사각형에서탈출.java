package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1085_직사각형에서탈출 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		int minX = 0;
		int minY = 0;

		if ((double) w / 2 > x)
			minX = x;
		else
			minX = w - x;

		if ((double) h / 2 > y)
			minY = y;
		else
			minY = h - y;

		System.out.println(Math.min(minX, minY));
	}
}