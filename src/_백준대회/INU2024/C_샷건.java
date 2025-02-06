package _백준대회.INU2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C_샷건 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[][] keyboard = new char[4][10];

		for (int i = 0; i < 4; i++) {
			String line = br.readLine();
			for (int j = 0; j < 10; j++) {
				keyboard[i][j] = line.charAt(j);
			}
		}

		String input = br.readLine();
		boolean[][] hit = new boolean[4][10];

		for (char c : input.toCharArray()) {
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 10; j++) {
					if (keyboard[i][j] == c) {
						hit[i][j] = true;
					}
				}
			}
		}

		for (int i = 1; i < 3; i++) {
			for (int j = 1; j < 9; j++) {
				if (isCenter(hit, i, j)) {
					System.out.println(keyboard[i][j]);
					return;
				}
			}
		}
	}

	private static boolean isCenter(boolean[][] hit, int i, int j) {
		for (int di = -1; di <= 1; di++) {
			for (int dj = -1; dj <= 1; dj++) {
				if (!hit[i + di][j + dj]) {
					return false;
				}
			}
		}
		return true;
	}

}
