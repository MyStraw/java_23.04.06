package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _5002_도어맨 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m = 0;
		int w = 0;
		int tempDiff = 0;
		int diff = Integer.parseInt(br.readLine());
		String line = br.readLine();
		char[] lineArray = line.toCharArray();

		for (int i = 0; i < lineArray.length; i++) {
			if (lineArray[i] == 'M')
				m++;
			else
				w++;
			tempDiff = Math.abs(m - w);

			if (tempDiff > diff) {
				if (i == lineArray.length - 1) {
					if (lineArray[i] == 'M')
						m--;
					else
						w--;
					break;
				} else {

					if (lineArray[i] == lineArray[i + 1]) {
						if (lineArray[i] == 'M')
							m--;
						else
							w--;
						break;
					} else {
						if (lineArray[i] == 'M')
							m--;
						else
							w--;
						char temp = lineArray[i];
						lineArray[i] = lineArray[i + 1];
						lineArray[i + 1] = temp;
						i--;
					}
				}
			}
		}

		System.out.println(m + w);
	}
}
