package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _30626_심심한마루 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		boolean circle[] = new boolean[360];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			for (int j = -b; j <= b; j++) {
				if (a + j < 0) {
					circle[a + j + 360] = true;
				} else if (a + j >= 360) {
					circle[a + j - 360] = true;
				} else {
					circle[a + j] = true;
				}

			}
		}
		int count = 0;
		for (int i = 0; i < circle.length; i++) {
			if (circle[i] == true) {
				count++;
			}
		}
		System.out.println(count);

	}

}
