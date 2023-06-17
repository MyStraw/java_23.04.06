package _스터디;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _6월24일_참외밭 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int melon[][] = new int[6][2];

		Queue<Integer> que = new LinkedList<>();

		int K = sc.nextInt();

		int seroTotal = 0;
		int seroMax = 0;
		int garoTotal = 0;
		int garoMax = 0;
		int garoSmall = 0;
		int seroSmall = 0;

		boolean jjak = true;
		boolean hole = true;

		for (int i = 0; i < 6; i++) {
			int compass = sc.nextInt();
			int length = sc.nextInt();
			melon[i][0] = compass;
			melon[i][1] = length;

			if (melon[i][0] == 3 | melon[i][0] == 4) {
				seroTotal += melon[i][1];
			}
			if (melon[i][0] == 1 | melon[i][0] == 2) {
				garoTotal += melon[i][1];
			}
		}
		seroMax = seroTotal / 2;
		garoMax = garoTotal / 2;

		for (int i = 0; i < 5; i++) {
			if ((melon[0][0] == 1 | melon[0][0] == 2)) {
				/////////////////////////////////////
				if (i % 2 == 0)
					if (melon[i][1] != garoMax && melon[i + 1][1] == seroMax) //////////// 기본 가
						garoSmall = garoMax - melon[i][1];

					else if (melon[i][1] == garoMax && melon[i + 1][1] != seroMax) //////////// 기본 세
						seroSmall = seroMax - melon[i + 1][1];
				
				
				//////////////////////////////////////
				if (i % 2 == 1)
					if (melon[i][1] == seroMax && melon[i + 1][1] != garoMax)
						garoSmall = garoMax - melon[i + 1][1];

					else if (melon[5][1] == seroMax && melon[0][1] != garoMax)
						garoSmall = garoMax - melon[5][1];

					else if (melon[i][1] != seroMax && melon[i + 1][1] == garoMax)
						seroSmall = seroMax - melon[i][1];

					else if (melon[5][1] != seroMax && melon[0][1] == garoMax)
						seroSmall = seroMax - melon[5][1];

				//////////////////////////////////////

			} else if ((melon[0][0] == 3 | melon[0][0] == 4)) {
				//////////////////////////////////////
				if (i % 2 == 1)
					if (melon[i][1] != garoMax && melon[i + 1][1] == seroMax) //////////// 기본 가
						garoSmall = garoMax - melon[i][1];

					else if (melon[5][1] != garoMax && melon[0][1] == seroMax)
						garoSmall = garoMax - melon[5][1];

					else if (melon[i][1] == garoMax && melon[i + 1][1] != seroMax) //////////// 기본 세
						seroSmall = seroMax - melon[i + 1][1];

					else if (melon[5][1] == garoMax && melon[0][1] != seroMax)
						seroSmall = seroMax - melon[0][1];
				//////////////////////////////////////
				if (i % 2 == 0)
					if (melon[i][1] == seroMax && melon[i + 1][1] != garoMax)
						garoSmall = garoMax - melon[i + 1][1];
					else if (melon[i][1] != seroMax && melon[i + 1][1] == garoMax)
						seroSmall = seroMax - melon[i][1];
				
					else if (i>=1 && melon[i-1][1] == garoMax && melon[i][1] != seroMax) //////////// 마이
						seroSmall = seroMax - melon[i][1];
				
			}
		}
		System.out.println((seroMax * garoMax - seroSmall * garoSmall) * K);
	}
}
