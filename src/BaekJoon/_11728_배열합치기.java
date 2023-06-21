package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/11728
public class _11728_배열합치기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int Na = Integer.parseInt(st.nextToken());
		int Nb = Integer.parseInt(st.nextToken());

		int bae[][][] = new int[Na][Nb][Na + Nb];

		for (int i = 0; i < 2; i++) {
			StringTokenizer stst = new StringTokenizer(br.readLine());
			for (int j = 0; j < Na; j++) {
				bae[i][j][0] = Integer.parseInt(stst.nextToken());
				System.out.print(bae[i][j][0]);
			}

		}

	}

}
