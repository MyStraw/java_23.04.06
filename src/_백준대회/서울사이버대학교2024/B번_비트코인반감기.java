package _백준대회.서울사이버대학교2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B번_비트코인반감기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");

		long r = Long.parseLong(input[0]);
		long k = Long.parseLong(input[1]);
		long m = Long.parseLong(input[2]);

		long halvingCount = m / k;

		for (int i = 0; i < halvingCount; i++) {
			r /= 2;
			if (r == 0)
				break;
		}

		System.out.println(r);
	}

}
