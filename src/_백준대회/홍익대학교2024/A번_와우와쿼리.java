package _백준대회.홍익대학교2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A번_와우와쿼리 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int Q = Integer.parseInt(br.readLine());

		for (int i = 0; i < Q; i++) {
			String S = br.readLine();
			int count = 0;
			for (int j = 0; j <= S.length() - 3; j++) {
				if (S.substring(j, j + 3).equals("WOW")) {
					count++;
				}
			}

			System.out.println(count);
		}

	}	

}
