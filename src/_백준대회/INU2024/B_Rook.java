package _백준대회.INU2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_Rook {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());

		st = new StringTokenizer(br.readLine());
		long x = Long.parseLong(st.nextToken());
		long y = Long.parseLong(st.nextToken());

		int move = 0;

		if (a == 0 || b == 0) {
			if ((a == 0 && x == 0 && y < b) || (b == 0 && y == 0 && x < a)) {
				move = 3;
			} else {
				move = 1;
			}
		} else if (x == 0 || y == 0) {
			move = 2;
		} else if ((x < a && y < b) || (x > a && y > b)) {
			move = 2;
		} else {
			move = 2;
		}

		System.out.println(move);
	}

}
