package _백준대회.나는코더다_2024_송년대회;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A번_촛불과그림자2 {
	// 점 클래스 정의
	static class Point {
		long x, y;

		Point(long x, long y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// 입력: 빨간색 다각형 꼭짓점 개수(N)와 파란색 다각형 꼭짓점 개수(M)
		int N = scanner.nextInt();
		int M = scanner.nextInt();

		// 빨간색 다각형 좌표 저장
		List<Point> redPolygon = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			long x = scanner.nextLong();
			long y = scanner.nextLong();
			redPolygon.add(new Point(x, y));
		}

		// 파란색 다각형 좌표 저장
		List<Point> bluePolygon = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			long x = scanner.nextLong();
			long y = scanner.nextLong();
			bluePolygon.add(new Point(x, y));
		}

		// 최소 촛불 개수 계산
		int result = calculateMinimumLights(redPolygon, bluePolygon);
		System.out.println(result);

		scanner.close();
	}

	// 최소 촛불 개수 계산 함수
	static int calculateMinimumLights(List<Point> redPolygon, List<Point> bluePolygon) {
		// Step 1: 빨간색 다각형에서 가시성 영역 계산
		List<Point> visibilityPoints = computeVisibility(redPolygon, bluePolygon);

		// Step 2: 가시성 영역을 완전히 커버하기 위한 최소 촛불 개수 계산
		return computeMinimumGuards(visibilityPoints);
	}

	// 빨간색 다각형 내부의 가시성 영역 계산
	static List<Point> computeVisibility(List<Point> redPolygon, List<Point> bluePolygon) {
		List<Point> visibilityPoints = new ArrayList<>();
		// 빨간색 다각형 내부에서 파란색 다각형에 의해 가려지지 않은 점 계산
		for (Point p : redPolygon) {
			if (!isInsidePolygon(p, bluePolygon)) {
				visibilityPoints.add(p);
			}
		}
		return visibilityPoints;
	}

	// 특정 점이 다각형 내부에 있는지 확인 (Ray-Casting 알고리즘 사용)
	static boolean isInsidePolygon(Point point, List<Point> polygon) {
		int crossings = 0;
		int n = polygon.size();
		for (int i = 0; i < n; i++) {
			Point p1 = polygon.get(i);
			Point p2 = polygon.get((i + 1) % n);
			if (rayCrossesSegment(point, p1, p2)) {
				crossings++;
			}
		}
		return crossings % 2 == 1; // 홀수면 내부, 짝수면 외부
	}

	// 점과 선분의 교차 여부 계산
	static boolean rayCrossesSegment(Point p, Point a, Point b) {
		if (a.y > b.y) {
			Point temp = a;
			a = b;
			b = temp;
		}
		if (p.y == a.y || p.y == b.y) {
			p.y += 1; // 점이 선분의 끝에 걸려있으면 약간 올림
		}
		if (p.y < a.y || p.y > b.y || p.x > Math.max(a.x, b.x)) {
			return false;
		}
		if (p.x < Math.min(a.x, b.x)) {
			return true;
		}
		double slope = (double) (b.x - a.x) / (b.y - a.y);
		double intersectX = a.x + slope * (p.y - a.y);
		return p.x < intersectX;
	}

	// 최소 촛불 개수를 계산 (가시성 그래프 기반)
	static int computeMinimumGuards(List<Point> visibilityPoints) {
		// 가시성 영역의 Convex Hull 계산
		List<Point> convexHull = computeConvexHull(visibilityPoints);

		// Convex Hull 위의 꼭짓점 개수가 최소 촛불 개수와 동일
		return convexHull.size();
	}

	// Convex Hull 계산 (Graham's Scan 알고리즘)
	static List<Point> computeConvexHull(List<Point> points) {
		points.sort((p1, p2) -> (p1.x == p2.x) ? Long.compare(p1.y, p2.y) : Long.compare(p1.x, p2.x));

		List<Point> hull = new ArrayList<>();

		// 하단 Hull 계산
		for (Point p : points) {
			while (hull.size() >= 2 && !isCounterClockwise(hull.get(hull.size() - 2), hull.get(hull.size() - 1), p)) {
				hull.remove(hull.size() - 1);
			}
			hull.add(p);
		}

		// 상단 Hull 계산
		int lowerHullSize = hull.size();
		for (int i = points.size() - 2; i >= 0; i--) {
			Point p = points.get(i);
			while (hull.size() > lowerHullSize
					&& !isCounterClockwise(hull.get(hull.size() - 2), hull.get(hull.size() - 1), p)) {
				hull.remove(hull.size() - 1);
			}
			hull.add(p);
		}

		hull.remove(hull.size() - 1); // 마지막 점 중복 제거
		return hull;
	}

	// 반시계 방향 여부 확인
	static boolean isCounterClockwise(Point a, Point b, Point c) {
		return (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x) > 0;
	}

}
