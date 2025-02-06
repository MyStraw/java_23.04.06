package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15973_두박스 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());

		int x1 = Integer.parseInt(st1.nextToken());
		int y1 = Integer.parseInt(st1.nextToken());
		int x2 = Integer.parseInt(st1.nextToken());
		int y2 = Integer.parseInt(st1.nextToken());

		int x3 = Integer.parseInt(st2.nextToken());
		int y3 = Integer.parseInt(st2.nextToken());
		int x4 = Integer.parseInt(st2.nextToken());
		int y4 = Integer.parseInt(st2.nextToken());

		String result = checkIntersection(x1, y1, x2, y2, x3, y3, x4, y4);
		System.out.println(result);
	}

	static String checkIntersection(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
		
		if (x2 < x3 || x4 < x1 || y2 < y3 || y4 < y1) {
			return "NULL";
		}

		
		if ((x1 == x4 && y1 == y4) || (x1 == x4 && y2 == y3) || (x2 == x3 && y1 == y4) || (x2 == x3 && y2 == y3)) {
			return "POINT";
		}

		
		if (x1 == x4 || x2 == x3 || y1 == y4 || y2 == y3) {
			return "LINE";
		}

		
		return "FACE";
	}

}
