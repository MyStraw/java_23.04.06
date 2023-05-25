package _스터디;

import java.util.Scanner;

public class Z {

	private static void DrawZ(int x, int y, int z) {
		int num = 0;
		if (z == 1) {
			num++;
			return;
		}

		int size = z / 2;

		int count = 0;
		for (int i = x; i < x + z; i += size) {
			for (int j = y; j < y + z; j += size) {
				count++;
				if (count == 4) {
					DrawZ(i, j, size);
				}
				// i는 사이즈만큼 증가
			}
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();

		int z = 1 << N; // 2의 3승 = Math.pow(2, 3); 이건 더블
		int Z[][] = new int[z][z];

		for (int i = 0; i < z * z; i++) {

		}

		DrawZ(0, 0, z);
	}

}
