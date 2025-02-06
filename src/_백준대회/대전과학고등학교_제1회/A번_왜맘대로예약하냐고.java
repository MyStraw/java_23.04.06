package _백준대회.대전과학고등학교_제1회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A번_왜맘대로예약하냐고 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		int N = Integer.parseInt(br.readLine());

		boolean canAllAttend = true;

		for (int i = 0; i < N; i++) {
			int K = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());

			boolean attendsX = false;
			for (int j = 0; j < K; j++) {
				int time = Integer.parseInt(st.nextToken());
				if (time == X) {
					attendsX = true;
				}
			}

			if (!attendsX) {
				canAllAttend = false;
			}
		}

		System.out.println(canAllAttend ? "YES" : "NO");
	}

}
