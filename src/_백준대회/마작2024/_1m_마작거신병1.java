package _백준대회.마작2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1m_마작거신병1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		int firstSum = (A + B - 1) % 4 + 1;
		int secondSum = (C + D - 1) % 4 + 1;

		int initialPlayer = 1;
		int intermediatePlayer = (initialPlayer + 4 - firstSum) % 4;
		if (intermediatePlayer == 0)
			intermediatePlayer = 4;

		int finalPlayer = (intermediatePlayer + 4 - secondSum) % 4;
		if (finalPlayer == 0)
			finalPlayer = 4;

		System.out.println(finalPlayer);
	}

}
