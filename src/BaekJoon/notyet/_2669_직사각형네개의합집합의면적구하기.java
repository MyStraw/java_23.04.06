package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2669_직사각형네개의합집합의면적구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean square[][] = new boolean[101][101];
		for (int i = 0; i < square.length; i++) {
			Arrays.fill(square[i], false);
		}

		int count = 0;
		for (int i = 0; i < 4; i++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			int lx = Integer.parseInt(st.nextToken());
			int ly = Integer.parseInt(st.nextToken());
			int rx = Integer.parseInt(st.nextToken());
			int ry = Integer.parseInt(st.nextToken());

			for (int j = lx; j < rx; j++) {
				for (int k = ly; k < ry; k++) {
					if(!square[k][j]) {
					square[k][j] = true;
					count++;
					}
					
				}
			}
		}		

		System.out.println(count);
	}
}
