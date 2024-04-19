package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10250_ACM호텔2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());		
		

		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int floor = Integer.parseInt(st.nextToken());
			int room = Integer.parseInt(st.nextToken());
			int customer = Integer.parseInt(st.nextToken());

			int[][] hotel = new int[floor][room];
			int count = 0;

			for (int j = 0; j < room; j++) {
				for (int k = 0; k < floor; k++) {
					count++;
					hotel[k][j] = count;
					if (count == customer) {
						System.out.println(String.format("%01d",k+1) + String.format("%02d", j+1));						
					}
				}
			}
		}
	}
}
