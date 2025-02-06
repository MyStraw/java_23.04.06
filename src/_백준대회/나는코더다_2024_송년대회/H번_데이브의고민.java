package _백준대회.나는코더다_2024_송년대회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class H번_데이브의고민 {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
	
		int[][] farm = new int[n][m];

		
		int[][] pattern = { { 1, 2, 3, 4, 5 }, { 3, 4, 5, 1, 2 }, { 5, 1, 2, 3, 4 }, { 2, 3, 4, 5, 1 },
				{ 4, 5, 1, 2, 3 } };

		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				farm[i][j] = pattern[i % 5][j % 5]; 
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sb.append(farm[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}

}
