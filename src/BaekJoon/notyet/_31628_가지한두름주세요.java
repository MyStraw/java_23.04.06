package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _31628_가지한두름주세요 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[][] gazi = new String[10][10];

		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				gazi[i][j] = st.nextToken();
			}
		}
		boolean found = false;
		
		for (int i = 0; i < 10; i++) {
			boolean garo = true;
			String hanjul = gazi[i][0];
			for (int j = 1; j < 10; j++) {
				if (!gazi[i][j].equals(hanjul)) {
					garo = false;
					break;
				}
			}
			if (garo) {
				found = true;
				break;
			}
		}
	
		if (!found) {
			for (int j = 0; j < 10; j++) {
				boolean sero = true;
				String hanjul = gazi[0][j];
				for (int i = 1; i < 10; i++) {
					if (!gazi[i][j].equals(hanjul)) {
						sero = false;
						break;
					}
				}
				if (sero) {
					found = true;
					break;
				}
			}
		}

		if (found) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}

	}
}
