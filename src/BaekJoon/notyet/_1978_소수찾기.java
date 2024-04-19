package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _1978_소수찾기 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int count = 0;
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {

			int su = Integer.parseInt(st.nextToken());
			boolean sosu = false;

			for (int j = 1; j <= su; j++) {
				if (j > 1 && su != j && su % j != 0) {
					sosu = true;
				}
				if (j > 1 && su != j && su % j == 0) {
					sosu = false;
					break;
				}
				if (su == 2) {
					sosu = true;
				}
			
			}
			if (sosu) {
				count++;
			}
		}
		bw.write(Integer.toString(count));
		bw.flush();
		bw.close();
	}

}
