package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _2839_설탕배달 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		 

		int N = Integer.parseInt(br.readLine());

		int _3n = 1;
		int _5n = 1;

		boolean t = false;

		int count = 0;
		int min = 5000;

		for (int i = 0; i < 1667; i++) {
			_3n = 3 * i;
			for (int j = 0; j <= 1000; j++) {
				_5n = 5 * j;
				if (_3n + _5n == N) {
					t = true;
					count = i + j;
					if (count < min) {
						min = count;
					}
				}
			}
		}
		if (t) {
			bw.write(Integer.toString(min));

		} else {
			bw.write("-1");
		}
		bw.flush();
		bw.close();

	}

}
