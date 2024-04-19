package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _9063_대지 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int maxX = -10000;
		int maxY = -10000;
		int minX = 10000;
		int minY = 10000;
		for (int i = 0; i < N; i++) {			
			st = new StringTokenizer(br.readLine());			
			int x = Integer.parseInt(st.nextToken());
			maxX = Math.max(x, maxX);
			minX = Math.min(x, minX);
			
			int y = Integer.parseInt(st.nextToken());
			maxY = Math.max(y, maxY);
			minY = Math.min(y, minY);
		}
		System.out.println((maxX - minX) * (maxY-minY));	
	}
}
