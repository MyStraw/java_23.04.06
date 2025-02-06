package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class _2571_색종이3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int paper[][] = new int[100][100];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for (int j = x; j < x + 10; j++) {
				for (int k = y; k < y + 10; k++) {
					paper[j][k] = 1;
				}
			}
		}

		int max = 0;
		int sero[] = new int[100];

		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (paper[i][j] == 1) {
					sero[j]++;
				} else {
					sero[j] = 0;
				}
			}
			max = Math.max(max, nubi(sero));

		}
		System.out.println(max);

	}

	static int nubi(int[] heights) {
		Stack<Integer> stack = new Stack<>();
		int maxArea = 0;
		for (int i = 0; i <= heights.length; i++) {
			int h = (i == heights.length ? 0 : heights[i]);
			while (!stack.isEmpty() && h < heights[stack.peek()]) {
				int height = heights[stack.pop()];
				int width = stack.isEmpty() ? i : i - stack.peek() - 1;
				maxArea = Math.max(maxArea, height * width);
			}
			stack.push(i);
		}
		return maxArea;
	}

}
