package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _28345_ImageFilter {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine()); 
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken()); 
			int C = Integer.parseInt(st.nextToken());
			int[][] H = new int[R][C];
			for (int i = 0; i < R; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < C; j++) {
					H[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int[][] filterNum = new int[R][C];
			int[][] diff = new int[R][C];
		
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					int A = (c > 0) ? H[r][c - 1] : 0;
					int B = (r > 0) ? H[r - 1][c] : 0;
					int C_val = (r > 0 && c > 0) ? H[r - 1][c - 1] : 0;

					
					int[] predictions = { 0, A, B, (A + B) / 2, A + B - C_val };

					int minDiff = Integer.MAX_VALUE;
					int bestFilter = 0;

				
					for (int f = 0; f < 5; f++) {
						int currentDiff = Math.abs(H[r][c] - predictions[f]);
						if (currentDiff < minDiff || (currentDiff == minDiff && f < bestFilter)) {
							minDiff = currentDiff;
							bestFilter = f;
						}
					}

					filterNum[r][c] = bestFilter;
					diff[r][c] = H[r][c] - predictions[bestFilter];
				}
			}
			
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					bw.write(filterNum[r][c] + " " + diff[r][c]);
					if (c < C - 1) {
						bw.write(" ");
					}
				}
				bw.newLine();
			}
		}

		br.close();
		bw.flush();
		bw.close();
	}

}
