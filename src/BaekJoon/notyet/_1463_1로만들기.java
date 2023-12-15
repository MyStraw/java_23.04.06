package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1463_1로만들기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int X = Integer.parseInt(br.readLine());
		int count = 0;

		while (X != 1) {
			if ((X - 1) % 6 == 0 && X > 6) {
				X -= 1;
				X /= 6;
				count++;
				count++;
				count++;
			}

			else if ((X - 2) % 6 == 0 && X > 6) {
				X -= 2;
				X /= 6;
				count++;
				count++;
				count++;
				count++;
			}

			else if (X % 6 == 0 && X >= 6) {
				X /= 6;
				count++;
				count++;

			} else if ((X - 1) % 3 == 0 && X > 3) {
				X -= 1;
				X /= 3;
				count++;
				count++;
			}

			else if ((X - 2) % 3 == 0 && X > 3) {
				X -= 2;
				X /= 3;
				count++;
				count++;
				count++;
			}

			else if (X % 3 == 0 && X >= 3) {
				X /= 3;
				count++;
			}

			else if ((X - 1) % 2 == 0 && X > 2) {
				X -= 1;
				X /= 2;
				count++;
				count++;
			}

			else if (X % 2 == 0 && X >= 2) {
				X /= 2;
				count++;
			}

			else {
				X -= 1;
				count++;
			}
		}
		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
	}
}
