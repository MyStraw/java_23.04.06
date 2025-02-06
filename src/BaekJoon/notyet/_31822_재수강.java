package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _31822_재수강 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String jae = br.readLine();

		String ho = jae.substring(0, 5);	

		int N = Integer.parseInt(br.readLine());

		int count = 0;
		String[] can = new String[N];
		for (int i = 0; i < N; i++) {
			can[i] = br.readLine();
			if (can[i].startsWith(ho)) {
				count++;
			}

		}
		System.out.println(count);

	}

}
