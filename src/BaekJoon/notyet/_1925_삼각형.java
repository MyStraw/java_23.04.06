package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _1925_삼각형 {
	static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Point[] points = new Point[3];
		for (int i = 0; i < 3; i++) {
			String[] input = br.readLine().split(" ");
			int x = Integer.parseInt(input[0]);
			int y = Integer.parseInt(input[1]);
			points[i] = new Point(x, y);
		}

		System.out.println(classifyTriangle(points));
	}

	static String classifyTriangle(Point[] points) {		
		double[] sides = new double[3];
		sides[0] = getDistance(points[0], points[1]);
		sides[1] = getDistance(points[1], points[2]);
		sides[2] = getDistance(points[2], points[0]);
	
		if (isCollinear(points)) {
			return "X";
		}
		
		double[] angles = new double[3];
		angles[0] = getAngle(sides[0], sides[1], sides[2]);
		angles[1] = getAngle(sides[1], sides[2], sides[0]);
		angles[2] = getAngle(sides[2], sides[0], sides[1]);

		double maxAngle = Math.toDegrees(Math.max(Math.max(angles[0], angles[1]), angles[2]));
	
		Arrays.sort(sides);
		
		if (Math.abs(sides[0] - sides[1]) < 1e-10 && Math.abs(sides[1] - sides[2]) < 1e-10) {
			return "JungTriangle";
		}
		
		if (Math.abs(sides[0] - sides[1]) < 1e-10 || Math.abs(sides[1] - sides[2]) < 1e-10
				|| Math.abs(sides[0] - sides[2]) < 1e-10) {
			if (maxAngle > 90)
				return "Dunkak2Triangle";
			if (Math.abs(maxAngle - 90) < 1e-10)
				return "Jikkak2Triangle";
			return "Yeahkak2Triangle";
		}
		
		if (maxAngle > 90)
			return "DunkakTriangle";
		if (Math.abs(maxAngle - 90) < 1e-10)
			return "JikkakTriangle";
		return "YeahkakTriangle";
	}
	
	static double getDistance(Point p1, Point p2) {
		return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
	}
	
	static double getAngle(double a, double b, double c) {
		return Math.acos((a * a + b * b - c * c) / (2 * a * b));
	}
	
	static boolean isCollinear(Point[] points) {
		int x1 = points[1].x - points[0].x;
		int y1 = points[1].y - points[0].y;
		int x2 = points[2].x - points[0].x;
		int y2 = points[2].y - points[0].y;
		
		return x1 * y2 == x2 * y1;
	}

}
