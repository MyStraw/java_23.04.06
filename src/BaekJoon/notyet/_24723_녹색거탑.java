package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _24723_녹색거탑 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		switch (n) {
		case 1:
			System.out.print(2);
			break;
		case 2:
			System.out.print(4);
			break;
		case 3:
			System.out.print(8);
			break;
		case 4:
			System.out.print(16);
			break;
		case 5:
			System.out.print(32);
			break;
		}
	}

}
