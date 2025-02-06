package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class _2121_넷이놀기 {
	static final int MAX = 1000000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int[][] points = new int[N][2];
		Set<Integer> xSet = new HashSet<>();
		Set<Integer> ySet = new HashSet<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			points[i][0] = x;
			points[i][1] = y;
			xSet.add(x);
			ySet.add(y);
		}

		List<Integer> xList = new ArrayList<>(xSet);
		List<Integer> yList = new ArrayList<>(ySet);
		Collections.sort(xList);
		Collections.sort(yList);

		Map<Integer, Integer> xCompress = new HashMap<>();
		Map<Integer, Integer> yCompress = new HashMap<>();
		for (int i = 0; i < xList.size(); i++)
			xCompress.put(xList.get(i), i);
		for (int i = 0; i < yList.size(); i++)
			yCompress.put(yList.get(i), i);

		boolean[][] exist = new boolean[xList.size()][yList.size()];
		for (int[] point : points) {
			exist[xCompress.get(point[0])][yCompress.get(point[1])] = true;
		}

		long count = 0;
		for (int[] point : points) {
			int x = xCompress.get(point[0]);
			int y = yCompress.get(point[1]);
			int x2 = lowerBound(xList, point[0] + A);
			int y2 = lowerBound(yList, point[1] + B);

			if (x2 < xList.size() && y2 < yList.size() && xList.get(x2) == point[0] + A && yList.get(y2) == point[1] + B
					&& exist[x][y2] && exist[x2][y] && exist[x2][y2]) {
				count++;
			}
		}

		System.out.println(count);
	}

	static int lowerBound(List<Integer> list, int target) {
		int left = 0, right = list.size();
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (list.get(mid) < target) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return left;
	}

}
