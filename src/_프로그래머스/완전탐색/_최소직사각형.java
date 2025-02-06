package _프로그래머스.완전탐색;

public class _최소직사각형 {
	public static void main(String[] args) {

		int[][] sizes = { { 60, 50 }, { 30, 70 }, { 60, 30 }, { 80, 40 } };

		for (int i = 0; i < sizes.length; i++) {
			if (sizes[i][0] < sizes[i][1]) {
				int temp = sizes[i][1];
				sizes[i][1] = sizes[i][0];
				sizes[i][0] = temp;
			}
		}

		int apMax = 0;
		int duiMax = 0;
		for (int i = 0; i < sizes.length; i++) {
			if (sizes[i][0] > apMax) {
				apMax = sizes[i][0];
			}
			if (sizes[i][1] > duiMax) {
				duiMax = sizes[i][1];
			}
		}
		System.out.println(apMax * duiMax);
	}

}
