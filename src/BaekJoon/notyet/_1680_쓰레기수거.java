package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1680_쓰레기수거 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); 

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int W = Integer.parseInt(st.nextToken()); 
			int N = Integer.parseInt(st.nextToken());

			int curLoad = 0; 
			int totalDistance = 0; 
			int lastDistance = 0;

			while (N-- > 0) {
				st = new StringTokenizer(br.readLine());
				int distance = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());

				curLoad += weight;

				if (curLoad > W) {
					totalDistance += distance;
					curLoad = weight; 
				}

				if (curLoad == W) {
					totalDistance += distance; 
					curLoad = 0;
				}

				lastDistance = distance;
			}

			if (curLoad > 0) {
				totalDistance += lastDistance; 
			}

			System.out.println(totalDistance * 2); 
		}
	}

}
