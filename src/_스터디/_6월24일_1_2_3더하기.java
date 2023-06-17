package _스터디;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _6월24일_1_2_3더하기 {

	static boolean haveOne(int num[][][], int x, int y) {

		for (int i = 0; i <= 10; i++) {
			if (num[x][y][i] == 1) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int T = Integer.parseInt(br.readLine());

		int Xn = 0;
		int Yn = 0;
		int Zn = 0;

		int num[][][] = new int[4][6][11];

		int count = 0;
		int count2 = 0;
		int count3 = 0;

		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			for (int x = 0; x <= 3; x++) {
				for (int y = 0; y <= 5; y++) {
					for (int z = 0; z <= 10; z++) {
						if (3 * x + 2 * y + z == n) {
							num[x][y][z] = 1;
							count++;
						}
					}
				}
			}
		}
		for (int x = 0; x <= 3; x++) {
			for (int y = 0; y <= 5; y++) {
				for (int z = 0; z <= 10; z++) {
					if (haveOne(num, x, y) && num[x][y][z] != 1) {
						count2++;
						break;
					}
				}
			}
		}
		System.out.println(count + count2);
	}
}