package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2930_가위바위보 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int round = Integer.parseInt(br.readLine());
		String sanggeun = br.readLine();
		int friends = Integer.parseInt(br.readLine());
		String[] friendMoves = new String[friends];
		for (int i = 0; i < friends; i++) {
			friendMoves[i] = br.readLine();
		}

		int sanggeunScore = 0;
		for (int i = 0; i < round; i++) {
			char sanggeunMove = sanggeun.charAt(i);
			for (String friendMove : friendMoves) {
				char friend = friendMove.charAt(i);
				if (sanggeunMove == friend) {
					sanggeunScore += 1;
				} else if ((sanggeunMove == 'S' && friend == 'P') || (sanggeunMove == 'P' && friend == 'R')
						|| (sanggeunMove == 'R' && friend == 'S')) {
					sanggeunScore += 2;
				}
			}
		}

		int max = 0;
		for (int i = 0; i < round; i++) {
			int roundMax = 0;
			for (char move : new char[] { 'S', 'P', 'R' }) {
				int score = 0;
				for (String friendMove : friendMoves) {
					char friend = friendMove.charAt(i);
					if (move == friend) {
						score += 1;
					} else if ((move == 'S' && friend == 'P') || (move == 'P' && friend == 'R')
							|| (move == 'R' && friend == 'S')) {
						score += 2;
					}
				}
				roundMax = Math.max(roundMax, score);
			}
			max += roundMax;
		}

		System.out.println(sanggeunScore);
		System.out.println(max);
	}

}
