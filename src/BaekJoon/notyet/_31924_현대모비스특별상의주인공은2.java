package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _31924_현대모비스특별상의주인공은2 {
	private static final String TARGET = "MOBIS";
	private static final int[] dx = { -1, -1, -1, 0, 1, 1, 1, 0 }; 
	private static final int[] dy = { -1, 0, 1, 1, 1, 0, -1, -1 }; 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		char[][] grid = new char[n][n];
	
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < n; j++) {
				grid[i][j] = line.charAt(j);
			}
		}

		int mobisCount = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 'M') {
					mobisCount += countMobis(grid, i, j, n);
				}
			}
		}

		System.out.println(mobisCount);
	}

	private static int countMobis(char[][] grid, int x, int y, int n) {
		int count = 0;
		for (int dir = 0; dir < 8; dir++) {
			int nx = x, ny = y;
			boolean isMobis = true;

			for (int k = 0; k < TARGET.length(); k++) {
				if (nx < 0 || nx >= n || ny < 0 || ny >= n || grid[nx][ny] != TARGET.charAt(k)) {
					isMobis = false;
					break;
				}
				nx += dx[dir];
				ny += dy[dir];
			}

			if (isMobis) {
				count++;
			}
		}
		return count;
	}

}
