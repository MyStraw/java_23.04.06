package _백준대회.카이스트_HAJE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A번_오버킬 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());

		int[] monster = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			monster[i] = Integer.parseInt(st.nextToken());
		}

		int turn = 0;
		int nowMon = 0;

		while (nowMon < N) {
			turn++;

			monster[nowMon] -= D;

			if (monster[nowMon] < 0) {
				int overkill = -monster[nowMon];
				nowMon++;

				if (nowMon < N) {
					int overkileDamage = (overkill * p) / 100;
					monster[nowMon] -= overkileDamage;
				}
			}

			while (nowMon < N && monster[nowMon] <= 0) {
				nowMon++;
			}
		}

		System.out.println(turn);

	}

}
